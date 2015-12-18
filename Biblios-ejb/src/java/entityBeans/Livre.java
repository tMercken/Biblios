/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityBeans;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author client
 */
@Entity
@Table(name = "LIVRE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Livre.findAll", query = "SELECT l FROM Livre l"),
    @NamedQuery(name = "Livre.findById", query = "SELECT l FROM Livre l WHERE l.id = :id"),
    @NamedQuery(name = "Livre.findByImage", query = "SELECT l FROM Livre l WHERE l.image = :image"),
    @NamedQuery(name = "Livre.findByNote", query = "SELECT l FROM Livre l WHERE l.note = :note"),
    @NamedQuery(name = "Livre.findByPrix", query = "SELECT l FROM Livre l WHERE l.prix = :prix"),
    @NamedQuery(name = "Livre.findByCategorie", query = "SELECT l FROM Livre l WHERE l.categorielivreId.id = :idCategorie")})
public class Livre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "IMAGE")
    private String image;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "NOTE")
    private Float note;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRIX")
    private float prix;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idlivre")
    private Collection<Lignecommande> lignecommandeCollection;
    @JoinColumn(name = "AUTEUR_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Auteur auteurId;
    @JoinColumn(name = "CATEGORIELIVRE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Categorie categorielivreId;
    @JoinColumn(name = "MAISONEDITION_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Maisonedition maisoneditionId;
    @JoinColumn(name = "PROMO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Promo promoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idlivre")
    private Collection<Traductionlivre> traductionlivreCollection;

    public Livre() {
    }

    public Livre(Integer id) {
        this.id = id;
    }

    public Livre(Integer id, float prix) {
        this.id = id;
        this.prix = prix;
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

    public Float getNote() {
        return note;
    }

    public void setNote(Float note) {
        this.note = note;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @XmlTransient
    public Collection<Lignecommande> getLignecommandeCollection() {
        return lignecommandeCollection;
    }

    public void setLignecommandeCollection(Collection<Lignecommande> lignecommandeCollection) {
        this.lignecommandeCollection = lignecommandeCollection;
    }

    public Auteur getAuteurId() {
        return auteurId;
    }

    public void setAuteurId(Auteur auteurId) {
        this.auteurId = auteurId;
    }

    public Categorie getCategorielivreId() {
        return categorielivreId;
    }

    public void setCategorielivreId(Categorie categorielivreId) {
        this.categorielivreId = categorielivreId;
    }

    public Maisonedition getMaisoneditionId() {
        return maisoneditionId;
    }

    public void setMaisoneditionId(Maisonedition maisoneditionId) {
        this.maisoneditionId = maisoneditionId;
    }

    public Promo getPromoId() {
        return promoId;
    }

    public void setPromoId(Promo promoId) {
        this.promoId = promoId;
    }

    @XmlTransient
    public Collection<Traductionlivre> getTraductionlivreCollection() {
        return traductionlivreCollection;
    }

    public void setTraductionlivreCollection(Collection<Traductionlivre> traductionlivreCollection) {
        this.traductionlivreCollection = traductionlivreCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livre)) {
            return false;
        }
        Livre other = (Livre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBeans.Livre[ id=" + id + " ]";
    }
    
}
