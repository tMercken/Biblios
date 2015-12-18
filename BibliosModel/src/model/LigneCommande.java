/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static java.util.Collections.list;

/**
 *
 * @author client
 */
public class LigneCommande {
    private Integer id;
    private int quantite;
    private Float prix;
    private Livre livreCommande;
    
    public LigneCommande (int quantite, float prix, Livre livre) {
        this.quantite = quantite;
        this.prix = prix;
        this.livreCommande = livre;
    }
    
    public String returnPrixLigneString() {
        Long price = Math.round(100 * this.prix.doubleValue());  
        Double priceDouble = price.doubleValue()/100;
        return priceDouble.toString();
    }

    public void addOne(){
        this.quantite += 1;
    }
    
    public void removeOne(){
        if (this.quantite > 0) {
            this.quantite -= 1;
        }        
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Livre getLivreCommande() {
        return livreCommande;
    }

    public void setLivreCommande(Livre livreCommande) {
        this.livreCommande = livreCommande;
    }
    
    
}
