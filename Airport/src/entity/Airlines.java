/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alex
 */
@Entity
@Table(name = "airlines")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Airlines.findAll", query = "SELECT a FROM Airlines a"),
    @NamedQuery(name = "Airlines.findByIdAirlines", query = "SELECT a FROM Airlines a WHERE a.idAirlines = :idAirlines"),
    @NamedQuery(name = "Airlines.findByNameAirline", query = "SELECT a FROM Airlines a WHERE a.nameAirline = :nameAirline")})
public class Airlines implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAirlines")
    private Integer idAirlines;
    @Basic(optional = false)
    @Column(name = "nameAirline")
    private String nameAirline;

    public Airlines() {
    }

    public Airlines(Integer idAirlines) {
        this.idAirlines = idAirlines;
    }

    public Airlines(Integer idAirlines, String nameAirline) {
        this.idAirlines = idAirlines;
        this.nameAirline = nameAirline;
    }

    public Integer getIdAirlines() {
        return idAirlines;
    }

    public void setIdAirlines(Integer idAirlines) {
        this.idAirlines = idAirlines;
    }

    public String getNameAirline() {
        return nameAirline;
    }

    public void setNameAirline(String nameAirline) {
        this.nameAirline = nameAirline;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAirlines != null ? idAirlines.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Airlines)) {
            return false;
        }
        Airlines other = (Airlines) object;
        if ((this.idAirlines == null && other.idAirlines != null) || (this.idAirlines != null && !this.idAirlines.equals(other.idAirlines))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Airlines[ idAirlines=" + idAirlines + " ]";
    }

    public void setidAirlines(int BYTES) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
