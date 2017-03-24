/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author xaviB
 */
@Entity
@Table(name = "Musician")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Musician.findAll", query = "SELECT m FROM Musician m"),
    @NamedQuery(name = "Musician.findByMusicianName", query = "SELECT m FROM Musician m WHERE m.musicianName = :musicianName"),
    @NamedQuery(name = "Musician.findByRole", query = "SELECT m FROM Musician m WHERE m.role = :role"),
    @NamedQuery(name = "Musician.findByBirthDate", query = "SELECT m FROM Musician m WHERE m.birthDate = :birthDate"),
    @NamedQuery(name = "Musician.findByBirthPlace", query = "SELECT m FROM Musician m WHERE m.birthPlace = :birthPlace")})
public class Musician implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Musician_Name")
    private String musicianName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Role")
    private String role;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BirthDate")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "BirthPlace")
    private String birthPlace;
    @JoinColumn(name = "Band", referencedColumnName = "Band_Name")
    @ManyToOne(optional = false)
    private Band band;

    public Musician() {
    }

    public Musician(String musicianName) {
        this.musicianName = musicianName;
    }

    public Musician(String musicianName, String role, Date birthDate, String birthPlace) {
        this.musicianName = musicianName;
        this.role = role;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
    }

    public String getMusicianName() {
        return musicianName;
    }

    public void setMusicianName(String musicianName) {
        this.musicianName = musicianName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Band getBand() {
        return band;
    }

    public void setBand(Band band) {
        this.band = band;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (musicianName != null ? musicianName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Musician)) {
            return false;
        }
        Musician other = (Musician) object;
        if ((this.musicianName == null && other.musicianName != null) || (this.musicianName != null && !this.musicianName.equals(other.musicianName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.Musician[ musicianName=" + musicianName + " ]";
    }
    
}
