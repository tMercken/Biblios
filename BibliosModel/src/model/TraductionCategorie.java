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
public class TraductionCategorie {
    private Integer id;
    private String libelle;
    private Categorie categorieTraduite;
    private Langue langueTraduite;
    
    public TraductionCategorie () {
    
    }
    
    public TraductionCategorie (int id, String libelle, Langue langueTrad) {
        this.id = id;
        this.libelle = libelle;
        this.langueTraduite = langueTrad;
        this.categorieTraduite = null;
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

    public Categorie getCategorieTraduite() {
        return categorieTraduite;
    }

    public void setCategorieTraduite(Categorie categorieTraduite) {
        this.categorieTraduite = categorieTraduite;
    }

    public Langue getLangueTraduite() {
        return langueTraduite;
    }

    public void setLangueTraduite(Langue langueTraduite) {
        this.langueTraduite = langueTraduite;
    }
    
    
}
