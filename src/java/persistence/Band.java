/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author xaviB
 */
@Entity
@Table(name = "Band")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Band.findAll", query = "SELECT b FROM Band b"),
    @NamedQuery(name = "Band.findByBandName", query = "SELECT b FROM Band b WHERE b.bandName = :bandName"),
    @NamedQuery(name = "Band.findByYear", query = "SELECT b FROM Band b WHERE b.year = :year"),
    @NamedQuery(name = "Band.findByGenre", query = "SELECT b FROM Band b WHERE b.genre = :genre"),
    @NamedQuery(name = "Band.findByCountry", query = "SELECT b FROM Band b WHERE b.country = :country")})
public class Band implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Band_Name")
    private String bandName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Year")
    private int year;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Genre")
    private String genre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Country")
    private String country;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "band")
    private Collection<Musician> musicianCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "band")
    private Collection<Album> albumCollection;

    public Band() {
    }

    public Band(String bandName) {
        this.bandName = bandName;
    }

    public Band(String bandName, int year, String genre, String country) {
        this.bandName = bandName;
        this.year = year;
        this.genre = genre;
        this.country = country;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @XmlTransient
    public Collection<Musician> getMusicianCollection() {
        return musicianCollection;
    }

    public void setMusicianCollection(Collection<Musician> musicianCollection) {
        this.musicianCollection = musicianCollection;
    }

    @XmlTransient
    public Collection<Album> getAlbumCollection() {
        return albumCollection;
    }

    public void setAlbumCollection(Collection<Album> albumCollection) {
        this.albumCollection = albumCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bandName != null ? bandName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Band)) {
            return false;
        }
        Band other = (Band) object;
        if ((this.bandName == null && other.bandName != null) || (this.bandName != null && !this.bandName.equals(other.bandName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.Band[ bandName=" + bandName + " ]";
    }
    
}
