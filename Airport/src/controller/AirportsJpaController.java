/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.exceptions.NonexistentEntityException;
import entity.Airports;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Alex
 */
public class AirportsJpaController implements Serializable {

    public AirportsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("AirportPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public AirportsJpaController() {
    }

    public void create(Airports airports) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(airports);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Airports airports) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            airports = em.merge(airports);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = airports.getIdAirports();
                if (findAirports(id) == null) {
                    throw new NonexistentEntityException("The airports with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Airports airports;
            try {
                airports = em.getReference(Airports.class, id);
                airports.getIdAirports();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The airports with id " + id + " no longer exists.", enfe);
            }
            em.remove(airports);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Airports> findAirportsEntities() {
        return findAirportsEntities(true, -1, -1);
    }

    public List<Airports> findAirportsEntities(int maxResults, int firstResult) {
        return findAirportsEntities(false, maxResults, firstResult);
    }

    private List<Airports> findAirportsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Airports.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Airports findAirports(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Airports.class, id);
        } finally {
            em.close();
        }
    }

    public int getAirportsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Airports> rt = cq.from(Airports.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
