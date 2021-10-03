/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.exceptions.NonexistentEntityException;
import entity.Airlines;
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
public class AirlinesJpaController implements Serializable {

    public AirlinesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("AirportPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
public AirlinesJpaController() {
    }

    public void create(Airlines airlines) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(airlines);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Airlines airlines) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            airlines = em.merge(airlines);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = airlines.getIdAirlines();
                if (findAirlines(id) == null) {
                    throw new NonexistentEntityException("The airlines with id " + id + " no longer exists.");
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
            Airlines airlines;
            try {
                airlines = em.getReference(Airlines.class, id);
                airlines.getIdAirlines();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The airlines with id " + id + " no longer exists.", enfe);
            }
            em.remove(airlines);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Airlines> findAirlinesEntities() {
        return findAirlinesEntities(true, -1, -1);
    }

    public List<Airlines> findAirlinesEntities(int maxResults, int firstResult) {
        return findAirlinesEntities(false, maxResults, firstResult);
    }

    private List<Airlines> findAirlinesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Airlines.class));
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

    public Airlines findAirlines(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Airlines.class, id);
        } finally {
            em.close();
        }
    }

    public int getAirlinesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Airlines> rt = cq.from(Airlines.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
