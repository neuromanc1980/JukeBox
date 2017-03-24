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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Album")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Album.findAll", query = "SELECT a FROM Album a"),
    @NamedQuery(name = "Album.findByAlbumName", query = "SELECT a FROM Album a WHERE a.albumName = :albumName"),
    @NamedQuery(name = "Album.findByGenre", query = "SELECT a FROM Album a WHERE a.genre = :genre"),
    @NamedQuery(name = "Album.findByDiscography", query = "SELECT a FROM Album a WHERE a.discography = :discography"),
    @NamedQuery(name = "Album.findByYear", query = "SELECT a FROM Album a WHERE a.year = :year")})
public class Album implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Album_Name")
    private String albumName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Genre")
    private String genre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Discography")
    private String discography;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Year")
    private int year;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "album")
    private Collection<Song> songCollection;
    @JoinColumn(name = "Band", referencedColumnName = "Band_Name")
    @ManyToOne(optional = false)
    private Band band;

    public Album() {
    }

    public Album(String albumName) {
        this.albumName = albumName;
    }

    public Album(String albumName, String genre, String discography, int year) {
        this.albumName = albumName;
        this.genre = genre;
        this.discography = discography;
        this.year = year;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDiscography() {
        return discography;
    }

    public void setDiscography(String discography) {
        this.discography = discography;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @XmlTransient
    public Collection<Song> getSongCollection() {
        return songCollection;
    }

    public void setSongCollection(Collection<Song> songCollection) {
        this.songCollection = songCollection;
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
        hash += (albumName != null ? albumName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Album)) {
            return false;
        }
        Album other = (Album) object;
        if ((this.albumName == null && other.albumName != null) || (this.albumName != null && !this.albumName.equals(other.albumName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.Album[ albumName=" + albumName + " ]";
    }
    
}
