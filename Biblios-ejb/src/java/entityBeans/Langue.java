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
@Table(name = "LANGUE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Langue.findAll", query = "SELECT l FROM Langue l"),
    @NamedQuery(name = "Langue.findById", query = "SELECT l FROM Langue l WHERE l.id = :id"),
    @NamedQuery(name = "Langue.findByLibelle", query = "SELECT l FROM Langue l WHERE l.libelle = :libelle"),
    @NamedQuery(name = "Langue.findByDrapeau", query = "SELECT l FROM Langue l WHERE l.drapeau = :drapeau")})
public class Langue implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LIBELLE")
    private String libelle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DRAPEAU")
    private String drapeau;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idlangue")
    private Collection<Traductioncategorie> traductioncategorieCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idlangue")
    private Collection<Traductionlivre> traductionlivreCollection;

    public Langue() {
    }

    public Langue(Integer id) {
        this.id = id;
    }

    public Langue(Integer id, String libelle, String drapeau) {
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

    @XmlTransient
    public Collection<Traductioncategorie> getTraductioncategorieCollection() {
        return traductioncategorieCollection;
    }

    public void setTraductioncategorieCollection(Collection<Traductioncategorie> traductioncategorieCollection) {
        this.traductioncategorieCollection = traductioncategorieCollection;
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
        if (!(object instanceof Langue)) {
            return false;
        }
        Langue other = (Langue) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBeans.Langue[ id=" + id + " ]";
    }
    
}
