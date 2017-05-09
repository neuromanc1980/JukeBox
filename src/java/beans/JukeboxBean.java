/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.math.BigDecimal;
import java.util.HashMap;
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
        System.out.println("SONG======> "+p);
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
      public List<Song> getSongsByName(String name){
      EntityManager em = emf.createEntityManager();
      Query q = em.createQuery("select b from Song b where b.songName like :songName");
      q.setParameter("songName", "%"+name+"%");
      List<Song> t = q.getResultList();
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
    
    public List<Song> getSongsByRanking() {
        EntityManager em = emf.createEntityManager();        
        // select s.album.band.name, sum(s.rating) from Song s groub by s.album.band
        Query q = em.createQuery("select s from Song s order by s.rating desc");
        List<Song> t = q.getResultList();
        return t;
    }
    
     public List<Song> getAlbumByRanking() {
        EntityManager em = emf.createEntityManager();        
        // select s.album.band.name, sum(s.rating) from Song s groub by s.album.band
        Query q = em.createQuery("select s.album.name from Song s group by s.album.name order by s.album.rating desc");
        List<Song> t = q.getResultList();
        return t;
    }
    
      public List<Song> SelectAllSongs(){
      EntityManager em = emf.createEntityManager();
      List<Song> resultado = em.createQuery("select s from Song s order by s.songName").getResultList();
      return resultado;
  }
      
      public List<Song> SongsByAlbum(String album){
      EntityManager em = emf.createEntityManager();
      System.out.println("Entra en el metodo");
      Query q = em.createQuery("select s from Song s where s.album.albumName like :album order by s.songName");
      q.setParameter("album", album);
      System.out.println(q);
      List <Song> resultado = q.getResultList();
      System.out.println("LIST=============" + resultado);
      return resultado;
      }
      //Método sin acabar
      public int SumByAlbum(String album){
      EntityManager em = emf.createEntityManager();
      System.out.println("Entra");
      Query q = em.createQuery("select sum(Rating) from Song a where album like albumName");
      q.setParameter("albumName", album);
      int resultado = q.getFirstResult();
      System.out.println("Resultado=====================" + resultado);
      return resultado;
      }
      
      public List<Song> getSongsByLength(){
      EntityManager em = emf.createEntityManager();
      System.out.println("Entra en el metodo");
      Query q = em.createQuery("select s from Song s order by s.length desc");
      //q.setParameter("length", length);
      System.out.println(q);
      List <Song> resultado = q.getResultList();
      System.out.println("LIST=============" + resultado);
      return resultado;  
          
      }
    
    
    
    
}
