/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author client
 */
public class Langue {
    private Integer id;
    private String libelle;
    private String drapeau;
    
    public Langue(){
        
    }
    
    public Langue(int id, String libelle, String drapeau ){
        this.id = id;
        this.libelle = libelle;
        this.drapeau = drapeau;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDrapeau() {
        return drapeau;
    }

    public void setDrapeau(String drapeau) {
        this.drapeau = drapeau;
    }
    
    
}
