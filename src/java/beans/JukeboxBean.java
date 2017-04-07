/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import persistence.Album;
import persistence.Band;

/**
 *
 * @author xaviB
 */
@Stateless
public class JukeboxBean {
    
    @PersistenceUnit EntityManagerFactory emf;
    
    public boolean insertBand(Band p){
        EntityManager em = emf.createEntityManager();
        Band band = em.find(Band.class, p.getBandName());
        if (band == null ){
            em.persist(p);
            em.flush();
            em.close();
            return true;
        }
        else return false;
    }
    public List<Band> SelectAllBands(){
      EntityManager em = emf.createEntityManager();
      List<Band> resultado = em.createNamedQuery("Band.findAll").getResultList();
      return resultado;
  }
    public String insertAlbum(Album p, String b){
        System.out.println("Enta1");
        EntityManager em = emf.createEntityManager();
        Album album = em.find(Album.class, p.getAlbumName());
        if (album == null ){
            System.out.println("Enta2");
            em.persist(p);
            em.flush();
            em.close();
            return "ok";
        }
        else return "Album already exists";
    }
    public Band getBandByName(String name){
      EntityManager em = emf.createEntityManager();
      Query q = em.createNamedQuery("Band.findByBandName");
      q.setParameter("bandName", name);
      Band t = (Band) q.getSingleResult();    
      return t;
      
  } 
    
    
    
    
}
