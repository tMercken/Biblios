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
@Table(name = "AUTEUR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auteur.findAll", query = "SELECT a FROM Auteur a"),
    @NamedQuery(name = "Auteur.findById", query = "SELECT a FROM Auteur a WHERE a.id = :id"),
    @NamedQuery(name = "Auteur.findByNom", query = "SELECT a FROM Auteur a WHERE a.nom = :nom"),
    @NamedQuery(name = "Auteur.findByPrenom", query = "SELECT a FROM Auteur a WHERE a.prenom = :prenom")})
public class Auteur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOM")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PRENOM")
    private String prenom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "auteurId")
    private Collection<Livre> livreCollection;

    public Auteur() {
    }

    public Auteur(Integer id) {
        this.id = id;
    }

    public Auteur(Integer id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @XmlTransient
    public Collection<Livre> getLivreCollection() {
        return livreCollection;
    }

    public void setLivreCollection(Collection<Livre> livreCollection) {
        this.livreCollection = livreCollection;
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
        if (!(object instanceof Auteur)) {
            return false;
        }
        Auteur other = (Auteur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBeans.Auteur[ id=" + id + " ]";
    }
    
}
