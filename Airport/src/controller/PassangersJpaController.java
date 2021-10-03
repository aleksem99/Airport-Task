/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.exceptions.NonexistentEntityException;
import entity.Passangers;
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
public class PassangersJpaController implements Serializable {

    public PassangersJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf =Persistence.createEntityManagerFactory("AirportPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public PassangersJpaController() {
    }

    public void create(Passangers passangers) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(passangers);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Passangers passangers) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            passangers = em.merge(passangers);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = passangers.getIdPassangers();
                if (findPassangers(id) == null) {
                    throw new NonexistentEntityException("The passangers with id " + id + " no longer exists.");
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
            Passangers passangers;
            try {
                passangers = em.getReference(Passangers.class, id);
                passangers.getIdPassangers();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The passangers with id " + id + " no longer exists.", enfe);
            }
            em.remove(passangers);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Passangers> findPassangersEntities() {
        return findPassangersEntities(true, -1, -1);
    }

    public List<Passangers> findPassangersEntities(int maxResults, int firstResult) {
        return findPassangersEntities(false, maxResults, firstResult);
    }

    private List<Passangers> findPassangersEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Passangers.class));
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

    public Passangers findPassangers(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Passangers.class, id);
        } finally {
            em.close();
        }
    }

    public int getPassangersCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Passangers> rt = cq.from(Passangers.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
