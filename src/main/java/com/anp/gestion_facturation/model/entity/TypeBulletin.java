package com.anp.gestion_facturation.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TypeBulletin
 */
@Entity
@Table(name = "types_bulletins")
public class TypeBulletin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_type_bulletin")
    private int codeTypeBulletin;

    @Column(name = "intitule_type_bulletin")
    private String intituleTypeBulletin;

    /**
     * @return the codeTypeBulletin
     */
    public int getCodeTypeBulletin() {
        return codeTypeBulletin;
    }

    /**
     * @param codeTypeBulletin the codeTypeBulletin to set
     */
    public void setCodeTypeBulletin(int codeTypeBulletin) {
        this.codeTypeBulletin = codeTypeBulletin;
    }

    /**
     * @return the intituleTypeBulletin
     */
    public String getIntituleTypeBulletin() {
        return intituleTypeBulletin;
    }

    /**
     * @param intituleTypeBulletin the intituleTypeBulletin to set
     */
    public void setIntituleTypeBulletin(String intituleTypeBulletin) {
        this.intituleTypeBulletin = intituleTypeBulletin;
    }

    @Override
    public String toString() {
        return "TypeBulletin : codeTypeBulletin = " + codeTypeBulletin + " intituleTypeBulletin = "
                + intituleTypeBulletin;
    }

}