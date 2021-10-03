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
@Table(name = "airports")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Airports.findAll", query = "SELECT a FROM Airports a"),
    @NamedQuery(name = "Airports.findByIdAirports", query = "SELECT a FROM Airports a WHERE a.idAirports = :idAirports"),
    @NamedQuery(name = "Airports.findByAirportCountry", query = "SELECT a FROM Airports a WHERE a.airportCountry = :airportCountry"),
    @NamedQuery(name = "Airports.findByAirportName", query = "SELECT a FROM Airports a WHERE a.airportName = :airportName"),
    @NamedQuery(name = "Airports.findByAirportTerminal", query = "SELECT a FROM Airports a WHERE a.airportTerminal = :airportTerminal")})
public class Airports implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAirports")
    private Integer idAirports;
    @Basic(optional = false)
    @Column(name = "airportCountry")
    private String airportCountry;
    @Basic(optional = false)
    @Column(name = "airportName")
    private String airportName;
    @Basic(optional = false)
    @Column(name = "airportTerminal")
    private int airportTerminal;

    public Airports() {
    }

    public Airports(Integer idAirports) {
        this.idAirports = idAirports;
    }

    public Airports(Integer idAirports, String airportCountry, String airportName, int airportTerminal) {
        this.idAirports = idAirports;
        this.airportCountry = airportCountry;
        this.airportName = airportName;
        this.airportTerminal = airportTerminal;
    }

    public Integer getIdAirports() {
        return idAirports;
    }

    public void setIdAirports(Integer idAirports) {
        this.idAirports = idAirports;
    }

    public String getAirportCountry() {
        return airportCountry;
    }

    public void setAirportCountry(String airportCountry) {
        this.airportCountry = airportCountry;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public int getAirportTerminal() {
        return airportTerminal;
    }

    public void setAirportTerminal(int airportTerminal) {
        this.airportTerminal = airportTerminal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAirports != null ? idAirports.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Airports)) {
            return false;
        }
        Airports other = (Airports) object;
        if ((this.idAirports == null && other.idAirports != null) || (this.idAirports != null && !this.idAirports.equals(other.idAirports))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Airports[ idAirports=" + idAirports + " ]";
    }
    
}
