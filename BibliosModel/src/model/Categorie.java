/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author client
 */
public class Categorie {
    private Integer id;
    private String tradFR;
    private String tradEN;
    private List<model.TraductionCategorie> listTrad;
    private List<model.Livre> listLivre;
    
    public Categorie () {
        
    }

    public String getTradFR() {
        return tradFR;
    }

    public void setTradFR(String tradFR) {
        this.tradFR = tradFR;
    }

    public String getTradEN() {
        return tradEN;
    }

    public void setTradEN(String tradEN) {
        this.tradEN = tradEN;
    }
    
    public Categorie (int id, List<model.TraductionCategorie> listTradCategorie) {
        this.id = id;
        this.listTrad = listTradCategorie;
        this.listLivre = null;
        tradFR = listTradCategorie.get(1).getLibelle();
        tradEN = listTradCategorie.get(2).getLibelle();
    }

    public Integer getId() {
        return id;
    }

    public List<Livre> getListLivre() {
        return listLivre;
    }

    public void setListLivre(List<Livre> listLivre) {
        this.listLivre = listLivre;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public List<model.TraductionCategorie> getListTrad() {
        return listTrad;
    }

    public void setListTrad(List<model.TraductionCategorie> listTrad) {
        this.listTrad = listTrad;
    }
    
}
