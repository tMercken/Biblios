/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author client
 */
public class Promo {
    private Integer id;
    private Date dateDebut;
    private Date dateFin;
    private Float prctReduc;
    
    public Promo (int id, Date dateDebut, Date dateFin, float pourcentReduct) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prctReduc = pourcentReduct;
    }
    
    public String procentString(){        
        Long pourcentage = Math.round(this.prctReduc.doubleValue() * 100); 
        return pourcentage.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public float getPrctReduc() {
        return prctReduc;
    }
    

    public void setPrctReduc(float prctReduc) {
        this.prctReduc = prctReduc;
    }
    
}
