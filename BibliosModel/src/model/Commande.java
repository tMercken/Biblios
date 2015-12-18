/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

//import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author client
 */
public class Commande {
    private Integer id;
    private Date date; 
    private HashMap<Integer, LigneCommande> ligneCommandeHashMap;
    private Client client;
    
    public Commande (Date dateCommande, HashMap<Integer, LigneCommande> ligneCommandeHashMap, Client clientCommande) {
        this.date = dateCommande;
        this.ligneCommandeHashMap = ligneCommandeHashMap;
        this.client = clientCommande;
    }

    public HashMap<Integer, LigneCommande> getLigneCommandeHashMap() {
        return ligneCommandeHashMap;
    }

    public void setLigneCommandeHashMap(HashMap<Integer, LigneCommande> ligneCommandeHashMap) {
        this.ligneCommandeHashMap = ligneCommandeHashMap;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
}
