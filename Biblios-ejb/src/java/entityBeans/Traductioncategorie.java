/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityBeans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author client
 */
@Entity
@Table(name = "TRADUCTIONCATEGORIE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Traductioncategorie.findAll", query = "SELECT t FROM Traductioncategorie t"),
    @NamedQuery(name = "Traductioncategorie.findById", query = "SELECT t FROM Traductioncategorie t WHERE t.id = :id"),
    @NamedQuery(name = "Traductioncategorie.findByLibelle", query = "SELECT t FROM Traductioncategorie t WHERE t.libelle = :libelle")})
public class Traductioncategorie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "LIBELLE")
    private String libelle;
    @JoinColumn(name = "IDCATEGORIE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Categorie idcategorie;
    @JoinColumn(name = "IDLANGUE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Langue idlangue;

    public Traductioncategorie() {
    }

    public Traductioncategorie(Integer id) {
        this.id = id;
    }

    public Traductioncategorie(Integer id, String libelle) {
        this.id = id;
        this.libelle = libelle;
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

    public Categorie getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(Categorie idcategorie) {
        this.idcategorie = idcategorie;
    }

    public Langue getIdlangue() {
        return idlangue;
    }

    public void setIdlangue(Langue idlangue) {
        this.idlangue = idlangue;
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
        if (!(object instanceof Traductioncategorie)) {
            return false;
        }
        Traductioncategorie other = (Traductioncategorie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBeans.Traductioncategorie[ id=" + id + " ]";
    }
    
}
