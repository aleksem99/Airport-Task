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
@Table(name = "flight")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Flight.findAll", query = "SELECT f FROM Flight f"),
    @NamedQuery(name = "Flight.findByFlightID", query = "SELECT f FROM Flight f WHERE f.flightID = :flightID"),
    @NamedQuery(name = "Flight.findByNameFlight", query = "SELECT f FROM Flight f WHERE f.nameFlight = :nameFlight")})
public class Flight implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FlightID")
    private Integer flightID;
    @Basic(optional = false)
    @Column(name = "nameFlight")
    private String nameFlight;

    public Flight() {
    }

    public Flight(Integer flightID) {
        this.flightID = flightID;
    }

    public Flight(Integer flightID, String nameFlight) {
        this.flightID = flightID;
        this.nameFlight = nameFlight;
    }

    public Integer getFlightID() {
        return flightID;
    }

    public void setFlightID(Integer flightID) {
        this.flightID = flightID;
    }

    public String getNameFlight() {
        return nameFlight;
    }

    public void setNameFlight(String nameFlight) {
        this.nameFlight = nameFlight;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (flightID != null ? flightID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Flight)) {
            return false;
        }
        Flight other = (Flight) object;
        if ((this.flightID == null && other.flightID != null) || (this.flightID != null && !this.flightID.equals(other.flightID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Flight[ flightID=" + flightID + " ]";
    }
    
}
