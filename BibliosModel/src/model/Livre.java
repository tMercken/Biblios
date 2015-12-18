/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author client
 */
public class Livre {
    private Integer id;
    private String image;
    private Double note;
    private float prix;
    private Promo promotionLivre;
    private Categorie categorieLivre;
    private Auteur auteur;
    private MaisonEdition maisonEdition; 
    private List<TraductionLivre> listTrad;
    private String tradResumeEN;
    private String tradResumeFR;
    private String tradTitreEN;
    private String tradTitreFR;

    public Livre(){
        
    }
    
    public Livre(int id, String image, Double note, float prix, Promo promoLivre , MaisonEdition maisonEdition, Auteur auteurLivre) {
        this.id = id;
        this.image = image;
        this.note = note;
        this.prix = prix;
        this.promotionLivre = promoLivre;
        this.categorieLivre = null;
        this.maisonEdition = maisonEdition;
        this.auteur = auteurLivre;
        this.listTrad = null;
    }
    
    public Boolean isInPromo(){
        if (this.promotionLivre != null){
            Date today = new Date();
            return (promotionLivre.getDateDebut().before(today) && promotionLivre.getDateFin().after(today));
        }
        return false; 
    }
    
    public Float returnPriceWithPromo(){
        Float price = this.getPrix();
        if(this.isInPromo()){
            price = this.getPrix() - this.getPrix() * this.getPromotionLivre().getPrctReduc();
        }
        
        return price;
    }
    
    //à supprimer, utiliser plutôt un converter
    //Le converter marche pas
    public String priceWithPromoString(){
        Long price = Math.round(100 * this.returnPriceWithPromo().doubleValue());  
        Double priceDouble = price.doubleValue()/100;
        return priceDouble.toString();
    }

    public List<TraductionLivre> getListTrad() {
        return listTrad;
    }

    public void setListTrad(List<TraductionLivre> listTrad) {
        this.listTrad = listTrad;
    }    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getNote() {
        return note;
    }

    public void setNote(Double note) {
        this.note = note;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Promo getPromotionLivre() {
        return promotionLivre;
    }

    public void setPromotionLivre(Promo promotionLivre) {
        this.promotionLivre = promotionLivre;
    }

    public Categorie getCategorieLivre() {
        return categorieLivre;
    }

    public void setCategorieLivre(Categorie categorieLivre) {
        this.categorieLivre = categorieLivre;
    }

    public String getTradResumeEN() {
        return tradResumeEN;
    }

    public void setTradResumeEN(String tradResumeEN) {
        this.tradResumeEN = tradResumeEN;
    }

    public String getTradResumeFR() {
        return tradResumeFR;
    }

    public void setTradResumeFR(String tradResumeFR) {
        this.tradResumeFR = tradResumeFR;
    }

    public String getTradTitreEN() {
        return tradTitreEN;
    }

    public void setTradTitreEN(String tradTitreEN) {
        this.tradTitreEN = tradTitreEN;
    }

    public String getTradTitreFR() {
        return tradTitreFR;
    }

    public void setTradTitreFR(String tradTitreFR) {
        this.tradTitreFR = tradTitreFR;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    public MaisonEdition getMaisonEdition() {
        return maisonEdition;
    }

    public void setMaisonEdition(MaisonEdition maisonEdition) {
        this.maisonEdition = maisonEdition;
    }
    
    
    
    
}
