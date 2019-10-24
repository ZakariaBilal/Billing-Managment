package com.anp.gestion_facturation.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import com.anp.gestion_facturation.model.entity.Bulletin;
import com.anp.gestion_facturation.model.entity.Facture;
import com.anp.gestion_facturation.model.entity.LigneBulletin;
import com.anp.gestion_facturation.model.entity.LigneFacture;
import com.anp.gestion_facturation.model.entity.TrancheTarif;

/**
 * Calculateur
 */
public class Calculateur {

    public static double calculerLigneBulletin(LigneBulletin ligneBulletin) {
        double montant = 0;
        double condition = 0;

        switch (ligneBulletin.getPrestation().getType()) {
        case "quantite":
            condition = ligneBulletin.getQuantite();
            montant = condition * ligneBulletin.getPrestation().getTarifByCondition(condition).getMontant();
            if (montant < ligneBulletin.getPrestation().getTarifByCondition(condition).getMontantMinimum()) {
                montant = ligneBulletin.getPrestation().getTarifByCondition(condition).getMontantMinimum();
            }
            break;
        case "tjbTranche":
            condition = ligneBulletin.getBulletin().getNavire().getJaugeBrute();
            montant = ligneBulletin.getQuantite()
                    * ligneBulletin.getPrestation().getTarifByCondition(condition).getMontant() * condition;
            if (montant < ligneBulletin.getPrestation().getTarifByCondition(condition).getMontantMinimum()) {
                montant = ligneBulletin.getPrestation().getTarifByCondition(condition).getMontantMinimum();
            }
            break;

        case "jourTranche":
            condition = ligneBulletin.getJours();

            for (TrancheTarif tranche : ligneBulletin.getPrestation().getTranches()) {

                if (condition < tranche.getMinJour()) {

                } else {
                    if (condition < tranche.getMaxJour()) {
                        montant += (condition - tranche.getMinJour()) * tranche.getMontant();
                        if (montant < tranche.getMontantMinimum()) {
                            montant = tranche.getMontantMinimum();
                        }
                    } else {
                        montant += (tranche.getMaxJour() - tranche.getMinJour()) * tranche.getMontant();

                    }
                }
            }
            break;
        case "heures":
            condition = ligneBulletin.getHours();
            System.out.println("nombres d'heures " + condition);
            if (0.5 < condition && condition < 1) {
                for (TrancheTarif tranche : ligneBulletin.getPrestation().getTranches()) {
                    System.out.println("montant de tranche " + tranche.getMontant());
                    if (tranche.getMaxCondition() == 1) {
                        montant = tranche.getMontant() * 2;
                    }
                }
            } else {
                if (condition <= 0.5) {
                    for (TrancheTarif tranche : ligneBulletin.getPrestation().getTranches()) {
                        if (tranche.getMaxCondition() == 1) {
                            montant = tranche.getMontant();
                        }
                    }
                }
                if (condition >= 1) {
                    for (TrancheTarif tranche : ligneBulletin.getPrestation().getTranches()) {
                        if (tranche.getMinCondition() == 1) {
                            montant = tranche.getMontant() * condition;
                        }
                    }
                }
            }

            break;
        case "tjbJour":
            condition = ligneBulletin.getBulletin().getNavire().getJaugeBrute();
            double jours = ligneBulletin.getJours();
            for (TrancheTarif tranche : ligneBulletin.getPrestation().getTarifJourByCondition(condition)) {
                if (jours < tranche.getMinJour()) {
                } else {
                    if (jours < tranche.getMaxJour()) {
                        montant += (jours - tranche.getMinJour()) * tranche.getMontant() * condition;
                        if (montant < tranche.getMontantMinimum()) {
                            montant = tranche.getMontantMinimum();
                        }
                    } else {
                        montant += (tranche.getMaxJour() - tranche.getMinJour()) * tranche.getMontant() * condition;

                    }
                }
            }

            break;
        case "quantiteTranche":
            condition = ligneBulletin.getQuantite();
            montant = ligneBulletin.getQuantite()
                    * ligneBulletin.getPrestation().getTarifByCondition(condition).getMontant();
            break;
        case "longueurNavire":
            condition = ligneBulletin.getBulletin().getNavire().getLongueurNavire();
            montant = ligneBulletin.getQuantite()
                    * ligneBulletin.getPrestation().getTarifByCondition(condition).getMontant();
            break;

        default:
            System.err.println("Type prestation introuvable");
            break;
        }

        if (ligneBulletin.getPrestation().isMajorationHoraire() && ligneBulletin.isHorsHoraire()) {
            if (ligneBulletin.getPrestation().isMajorationFeriee() && ligneBulletin.insideFeriee()) {
                montant *= 2;
            } else {
                montant *= 1.5;
            }
        }
        return montant;

    }

    public static LigneFacture calculerLigneFacture(LigneBulletin ligneBulletin) {
        LigneFacture ligneFacture = new LigneFacture();
        ligneFacture.setLigneBulletin(ligneBulletin);

        BigDecimal montantBd = new BigDecimal(calculerLigneBulletin(ligneBulletin)).setScale(2, RoundingMode.CEILING);

        double montant = montantBd.doubleValue();

        BigDecimal montantTVABd = new BigDecimal(montant * ligneBulletin.getPrestation().getTva().getTauxTva())
                .setScale(2, RoundingMode.CEILING);

        double montantTVA = montantTVABd.doubleValue();
        BigDecimal montantTTCBd = new BigDecimal(montant + montantTVA).setScale(2, RoundingMode.CEILING);
        double montantTTC = montantTTCBd.doubleValue();

        ligneFacture.setMontantHTC(montant);
        ligneFacture.setMontantTVA(montantTVA);
        ligneFacture.setMontantTTC(montantTTC);

        return ligneFacture;
    }

    public static Facture createFactureFromBulletin(Bulletin bulletin) {
        Facture facture = new Facture();
        double montantHTC = 0;
        double montantTVA = 0;
        double montantTTC = 0;
        ArrayList<LigneFacture> ligneFactures = new ArrayList<>();
        for (LigneBulletin ligneBulletin : bulletin.getLigneBulletins()) {
            LigneFacture ligneFacture = calculerLigneFacture(ligneBulletin);
            ligneFacture.setFacture(facture);
            ligneFactures.add(ligneFacture);
            montantHTC += ligneFacture.getMontantHTC();
            montantTTC += ligneFacture.getMontantTTC();
            montantTVA += ligneFacture.getMontantTVA();
        }

        facture.setBulletin(bulletin);
        facture.setLigneFactures(ligneFactures);
        facture.setMontantHTC(montantHTC);
        facture.setMontantTTC(montantTTC);
        facture.setMontantTVA(montantTVA);
        facture.setMontantTaxeRegionale(montantHTC * bulletin.getPort().getTaxeRegionale());

        return facture;
    }
}