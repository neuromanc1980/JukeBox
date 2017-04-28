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
import persistence.Musician;
import persistence.Song;

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
    public boolean insertSong(Song p){
        EntityManager em = emf.createEntityManager();
        Song song = em.find(Song.class, p.getSongName());
        if (song == null ){
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
    public List<Album> SelectAllAlbums(){
      EntityManager em = emf.createEntityManager();
      List<Album> resultado = em.createQuery("select a from Album a order by a.band.bandName").getResultList();
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
    public String insertMusician(Musician p, String b){
        System.out.println("Enta1");
        EntityManager em = emf.createEntityManager();
        Musician m = em.find(Musician.class, p.getMusicianName());
        if (m == null ){
            System.out.println("Enta2");
            em.persist(p);
            em.flush();
            em.close();
            return "ok";
        }
        else return "Musician already exists";
    }
    
    public Band getBandByName(String name){
      EntityManager em = emf.createEntityManager();
      Query q = em.createNamedQuery("Band.findByBandName");
      q.setParameter("bandName", name);
      Band t = (Band) q.getSingleResult();    
      return t;      
  }
    
      public List<Band> getBandsByName(String name){
      EntityManager em = emf.createEntityManager();
      Query q = em.createQuery("select b from Band b where b.bandName like :bandName");
      q.setParameter("bandName", "%"+name+"%");
      List<Band> t = q.getResultList();
      return t;
      
  }
    
      public List<Band> getBandsByYear(int year){
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select b from Band b where b.year like :year");
        q.setParameter("year", year);
        List<Band> t = q.getResultList();
        return t;
      }
      
    public Album getAlbumByName(String name){
      EntityManager em = emf.createEntityManager();
      Query q = em.createNamedQuery("Album.findByAlbumName");
      q.setParameter("albumName", name);
      Album t = (Album) q.getSingleResult();    
      return t;
      
  }
    
    
    
    
}
