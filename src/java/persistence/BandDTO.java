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
public class BandDTO {
   
    private Band band;
    private double suma;

    public BandDTO(Band band, double suma) {
        this.band = band;
        this.suma = suma;
    }

    public BandDTO() {
    }

    public Band getBand() {        return band;    }
    public void setBand(Band band) {        this.band = band;    }

    public double getSuma() {        return suma;    }
    public void setSuma(double suma) {        this.suma = suma;    }
       
    
}
