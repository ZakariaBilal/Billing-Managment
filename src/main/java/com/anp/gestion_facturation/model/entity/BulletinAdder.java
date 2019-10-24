package com.anp.gestion_facturation.model.entity;

// import java.util.List;

import com.anp.gestion_facturation.model.entity.LigneBulletin;


import com.anp.gestion_facturation.model.entity.Bulletin;

/**
 * BulletinAdder
 */

public class BulletinAdder {

    private Bulletin bulletin;

    private LigneBulletin ligneBulletins;

    public BulletinAdder() {

    }

    public BulletinAdder(Bulletin bulletin, LigneBulletin ligneBulletins) {
        this.bulletin = bulletin;

        this.ligneBulletins = ligneBulletins;

    }

    /**
     * @return the bulletin
     */
    public Bulletin getBulletin() {
        return bulletin;
    }

    /**
     * @param bulletin the bulletin to set
     */
    public void setBulletin(Bulletin bulletin) {
        this.bulletin = bulletin;
    }

    /**
     * @return the ligneBulletins
     */
    public LigneBulletin getLigneBulletins() {
        return ligneBulletins;
    }

    /**
     * @param ligneBulletins the ligneBulletins to set
     */
    public void setLigneBulletins(LigneBulletin ligneBulletins) {
        this.ligneBulletins = ligneBulletins;
    }

}