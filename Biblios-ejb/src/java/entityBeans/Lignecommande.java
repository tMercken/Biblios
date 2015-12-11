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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author client
 */
@Entity
@Table(name = "LIGNECOMMANDE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lignecommande.findAll", query = "SELECT l FROM Lignecommande l"),
    @NamedQuery(name = "Lignecommande.findById", query = "SELECT l FROM Lignecommande l WHERE l.id = :id"),
    @NamedQuery(name = "Lignecommande.findByQ", query = "SELECT l FROM Lignecommande l WHERE l.q = :q"),
    @NamedQuery(name = "Lignecommande.findByPrix", query = "SELECT l FROM Lignecommande l WHERE l.prix = :prix")})
public class Lignecommande implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Q")
    private int q;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRIX")
    private float prix;
    @JoinColumn(name = "IDCOMMANDE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Commande idcommande;
    @JoinColumn(name = "IDLIVRE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Livre idlivre;

    public Lignecommande() {
    }

    public Lignecommande(Integer id) {
        this.id = id;
    }

    public Lignecommande(Integer id, int q, float prix) {
        this.id = id;
        this.q = q;
        this.prix = prix;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQ() {
        return q;
    }

    public void setQ(int q) {
        this.q = q;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Commande getIdcommande() {
        return idcommande;
    }

    public void setIdcommande(Commande idcommande) {
        this.idcommande = idcommande;
    }

    public Livre getIdlivre() {
        return idlivre;
    }

    public void setIdlivre(Livre idlivre) {
        this.idlivre = idlivre;
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
        if (!(object instanceof Lignecommande)) {
            return false;
        }
        Lignecommande other = (Lignecommande) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBeans.Lignecommande[ id=" + id + " ]";
    }
    
}
