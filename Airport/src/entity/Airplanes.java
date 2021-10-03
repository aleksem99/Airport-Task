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
@Table(name = "airplanes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Airplanes.findAll", query = "SELECT a FROM Airplanes a"),
    @NamedQuery(name = "Airplanes.findByIdAirplanes", query = "SELECT a FROM Airplanes a WHERE a.idAirplanes = :idAirplanes"),
    @NamedQuery(name = "Airplanes.findByAirplaneManufacter", query = "SELECT a FROM Airplanes a WHERE a.airplaneManufacter = :airplaneManufacter"),
    @NamedQuery(name = "Airplanes.findByAirplaneModel", query = "SELECT a FROM Airplanes a WHERE a.airplaneModel = :airplaneModel")})
public class Airplanes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAirplanes")
    private Integer idAirplanes;
    @Basic(optional = false)
    @Column(name = "airplaneManufacter")
    private String airplaneManufacter;
    @Basic(optional = false)
    @Column(name = "airplaneModel")
    private String airplaneModel;

    public Airplanes() {
    }

    public Airplanes(Integer idAirplanes) {
        this.idAirplanes = idAirplanes;
    }

    public Airplanes(Integer idAirplanes, String airplaneManufacter, String airplaneModel) {
        this.idAirplanes = idAirplanes;
        this.airplaneManufacter = airplaneManufacter;
        this.airplaneModel = airplaneModel;
    }

    public Integer getIdAirplanes() {
        return idAirplanes;
    }

    public void setIdAirplanes(Integer idAirplanes) {
        this.idAirplanes = idAirplanes;
    }

    public String getAirplaneManufacter() {
        return airplaneManufacter;
    }

    public void setAirplaneManufacter(String airplaneManufacter) {
        this.airplaneManufacter = airplaneManufacter;
    }

    public String getAirplaneModel() {
        return airplaneModel;
    }

    public void setAirplaneModel(String airplaneModel) {
        this.airplaneModel = airplaneModel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAirplanes != null ? idAirplanes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Airplanes)) {
            return false;
        }
        Airplanes other = (Airplanes) object;
        if ((this.idAirplanes == null && other.idAirplanes != null) || (this.idAirplanes != null && !this.idAirplanes.equals(other.idAirplanes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Airplanes[ idAirplanes=" + idAirplanes + " ]";
    }
    
}
