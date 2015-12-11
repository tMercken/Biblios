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
@Table(name = "TRADUCTIONLIVRE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Traductionlivre.findAll", query = "SELECT t FROM Traductionlivre t"),
    @NamedQuery(name = "Traductionlivre.findById", query = "SELECT t FROM Traductionlivre t WHERE t.id = :id"),
    @NamedQuery(name = "Traductionlivre.findByTitre", query = "SELECT t FROM Traductionlivre t WHERE t.titre = :titre"),
    @NamedQuery(name = "Traductionlivre.findByResume", query = "SELECT t FROM Traductionlivre t WHERE t.resume = :resume")})
public class Traductionlivre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "TITRE")
    private String titre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "RESUME")
    private String resume;
    @JoinColumn(name = "IDLANGUE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Langue idlangue;
    @JoinColumn(name = "IDLIVRE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Livre idlivre;

    public Traductionlivre() {
    }

    public Traductionlivre(Integer id) {
        this.id = id;
    }

    public Traductionlivre(Integer id, String titre, String resume) {
        this.id = id;
        this.titre = titre;
        this.resume = resume;
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

    public Langue getIdlangue() {
        return idlangue;
    }

    public void setIdlangue(Langue idlangue) {
        this.idlangue = idlangue;
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
        if (!(object instanceof Traductionlivre)) {
            return false;
        }
        Traductionlivre other = (Traductionlivre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBeans.Traductionlivre[ id=" + id + " ]";
    }
    
}
