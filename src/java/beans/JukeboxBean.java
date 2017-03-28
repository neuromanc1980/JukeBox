/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
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
    
}
