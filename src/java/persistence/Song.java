/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author xaviB
 */
@Entity
@Table(name = "Song")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Song.findAll", query = "SELECT s FROM Song s"),
    @NamedQuery(name = "Song.findBySongName", query = "SELECT s FROM Song s WHERE s.songName = :songName"),
    @NamedQuery(name = "Song.findByRating", query = "SELECT s FROM Song s WHERE s.rating = :rating"),
    @NamedQuery(name = "Song.findByLength", query = "SELECT s FROM Song s WHERE s.length = :length")})
public class Song implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Song_Name")
    private String songName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Rating")
    private int rating;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Length")
    private double length;
    @JoinColumn(name = "Album", referencedColumnName = "Album_Name")
    @ManyToOne(optional = false)
    private Album album;

    public Song() {
    }

    public Song(String songName) {
        this.songName = songName;
    }

    public Song(String songName, int rating, double length) {
        this.songName = songName;
        this.rating = rating;
        this.length = length;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (songName != null ? songName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Song)) {
            return false;
        }
        Song other = (Song) object;
        if ((this.songName == null && other.songName != null) || (this.songName != null && !this.songName.equals(other.songName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.Song[ songName=" + songName + " ]";
    }
    
}
