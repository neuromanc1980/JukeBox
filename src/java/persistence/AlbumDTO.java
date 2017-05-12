/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

/**
 *
 * @author xaviB
 * clase para recoger album con rating
 */
public class AlbumDTO {
   
    private Album album;
    private double suma;
    

    public AlbumDTO(Album album, double suma) {
        this.album = album;
        this.suma = suma;
    }

    public AlbumDTO() {
    }

    public Album getAlbum() {        return album;    }
    public void setAlbum(Album album) {        this.album = album;    }

    public double getSuma() {        return suma;    }
    public void setSuma(double suma) {        this.suma = suma;    }
       
    
}
