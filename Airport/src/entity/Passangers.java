/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alex
 */
@Entity
@Table(name = "passangers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Passangers.findAll", query = "SELECT p FROM Passangers p"),
    @NamedQuery(name = "Passangers.findByIdPassangers", query = "SELECT p FROM Passangers p WHERE p.idPassangers = :idPassangers"),
    @NamedQuery(name = "Passangers.findByName", query = "SELECT p FROM Passangers p WHERE p.name = :name"),
    @NamedQuery(name = "Passangers.findByLastName", query = "SELECT p FROM Passangers p WHERE p.lastName = :lastName"),
    @NamedQuery(name = "Passangers.findByBirthdate", query = "SELECT p FROM Passangers p WHERE p.birthdate = :birthdate"),
    @NamedQuery(name = "Passangers.findByPhoneNumber", query = "SELECT p FROM Passangers p WHERE p.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "Passangers.findByEmail", query = "SELECT p FROM Passangers p WHERE p.email = :email")})
public class Passangers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPassangers")
    private Integer idPassangers;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "lastName")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "birthdate")
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    @Basic(optional = false)
    @Column(name = "phoneNumber")
    private int phoneNumber;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;

    public Passangers() {
    }

    public Passangers(Integer idPassangers) {
        this.idPassangers = idPassangers;
    }

    public Passangers(Integer idPassangers, String name, String lastName, Date birthdate, int phoneNumber, String email) {
        this.idPassangers = idPassangers;
        this.name = name;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Integer getIdPassangers() {
        return idPassangers;
    }

    public void setIdPassangers(Integer idPassangers) {
        this.idPassangers = idPassangers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPassangers != null ? idPassangers.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Passangers)) {
            return false;
        }
        Passangers other = (Passangers) object;
        if ((this.idPassangers == null && other.idPassangers != null) || (this.idPassangers != null && !this.idPassangers.equals(other.idPassangers))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Passangers[ idPassangers=" + idPassangers + " ]";
    }
    
}
