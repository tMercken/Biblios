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
public class TraductionLivre {
    private Integer id;
    private String titre;
    private String resume;
    private Livre livretraduit;
    private Langue langueTraduite;
    
    public TraductionLivre(int id, String titre, String resume, Langue langueTraduite) {
        this.id = id;
        this.titre = titre;
        this.resume = resume;
        this.livretraduit = null;
        this.langueTraduite = langueTraduite;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Livre getLivretraduit() {
        return livretraduit;
    }

    public void setLivretraduit(Livre livretraduit) {
        this.livretraduit = livretraduit;
    }

    public Langue getLangueTraduite() {
        return langueTraduite;
    }

    public void setLangueTraduite(Langue langueTraduite) {
        this.langueTraduite = langueTraduite;
    }
    
    
}
