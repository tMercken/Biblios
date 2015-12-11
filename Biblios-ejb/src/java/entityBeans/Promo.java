/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityBeans;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author client
 */
@Entity
@Table(name = "PROMO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promo.findAll", query = "SELECT p FROM Promo p"),
    @NamedQuery(name = "Promo.findById", query = "SELECT p FROM Promo p WHERE p.id = :id"),
    @NamedQuery(name = "Promo.findByDatedebut", query = "SELECT p FROM Promo p WHERE p.datedebut = :datedebut"),
    @NamedQuery(name = "Promo.findByDatefin", query = "SELECT p FROM Promo p WHERE p.datefin = :datefin"),
    @NamedQuery(name = "Promo.findByPrctreduc", query = "SELECT p FROM Promo p WHERE p.prctreduc = :prctreduc")})
public class Promo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATEDEBUT")
    @Temporal(TemporalType.DATE)
    private Date datedebut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATEFIN")
    @Temporal(TemporalType.DATE)
    private Date datefin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRCTREDUC")
    private float prctreduc;
    @OneToMany(mappedBy = "promoId")
    private Collection<Livre> livreCollection;

    public Promo() {
    }

    public Promo(Integer id) {
        this.id = id;
    }

    public Promo(Integer id, Date datedebut, Date datefin, float prctreduc) {
        this.id = id;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.prctreduc = prctreduc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public float getPrctreduc() {
        return prctreduc;
    }

    public void setPrctreduc(float prctreduc) {
        this.prctreduc = prctreduc;
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
        if (!(object instanceof Promo)) {
            return false;
        }
        Promo other = (Promo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBeans.Promo[ id=" + id + " ]";
    }
    
}
