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
@Table(name = "route")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Route.findAll", query = "SELECT r FROM Route r"),
    @NamedQuery(name = "Route.findByIdRoute", query = "SELECT r FROM Route r WHERE r.idRoute = :idRoute"),
    @NamedQuery(name = "Route.findByDepartureCountry", query = "SELECT r FROM Route r WHERE r.departureCountry = :departureCountry"),
    @NamedQuery(name = "Route.findByDepartureCity", query = "SELECT r FROM Route r WHERE r.departureCity = :departureCity"),
    @NamedQuery(name = "Route.findByEntryCountry", query = "SELECT r FROM Route r WHERE r.entryCountry = :entryCountry"),
    @NamedQuery(name = "Route.findByEntryCity", query = "SELECT r FROM Route r WHERE r.entryCity = :entryCity"),
    @NamedQuery(name = "Route.findByScaledCountry", query = "SELECT r FROM Route r WHERE r.scaledCountry = :scaledCountry"),
    @NamedQuery(name = "Route.findByScaledCity", query = "SELECT r FROM Route r WHERE r.scaledCity = :scaledCity")})
public class Route implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRoute")
    private Integer idRoute;
    @Basic(optional = false)
    @Column(name = "departureCountry")
    private String departureCountry;
    @Basic(optional = false)
    @Column(name = "departureCity")
    private String departureCity;
    @Basic(optional = false)
    @Column(name = "entryCountry")
    private String entryCountry;
    @Basic(optional = false)
    @Column(name = "entryCity")
    private String entryCity;
    @Basic(optional = false)
    @Column(name = "scaledCountry")
    private String scaledCountry;
    @Basic(optional = false)
    @Column(name = "scaledCity")
    private String scaledCity;

    public Route() {
    }

    public Route(Integer idRoute) {
        this.idRoute = idRoute;
    }

    public Route(Integer idRoute, String departureCountry, String departureCity, String entryCountry, String entryCity, String scaledCountry, String scaledCity) {
        this.idRoute = idRoute;
        this.departureCountry = departureCountry;
        this.departureCity = departureCity;
        this.entryCountry = entryCountry;
        this.entryCity = entryCity;
        this.scaledCountry = scaledCountry;
        this.scaledCity = scaledCity;
    }

    public Integer getIdRoute() {
        return idRoute;
    }

    public void setIdRoute(Integer idRoute) {
        this.idRoute = idRoute;
    }

    public String getDepartureCountry() {
        return departureCountry;
    }

    public void setDepartureCountry(String departureCountry) {
        this.departureCountry = departureCountry;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getEntryCountry() {
        return entryCountry;
    }

    public void setEntryCountry(String entryCountry) {
        this.entryCountry = entryCountry;
    }

    public String getEntryCity() {
        return entryCity;
    }

    public void setEntryCity(String entryCity) {
        this.entryCity = entryCity;
    }

    public String getScaledCountry() {
        return scaledCountry;
    }

    public void setScaledCountry(String scaledCountry) {
        this.scaledCountry = scaledCountry;
    }

    public String getScaledCity() {
        return scaledCity;
    }

    public void setScaledCity(String scaledCity) {
        this.scaledCity = scaledCity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRoute != null ? idRoute.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Route)) {
            return false;
        }
        Route other = (Route) object;
        if ((this.idRoute == null && other.idRoute != null) || (this.idRoute != null && !this.idRoute.equals(other.idRoute))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Route[ idRoute=" + idRoute + " ]";
    }
    
}
