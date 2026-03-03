package org.example.esocial.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.esocial.model.Employeur;
import java.util.List;

public class EmployeurDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("esocial");

    public void save(Employeur e) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }

    public List<Employeur> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Employeur> liste = em.createQuery("SELECT e FROM Employeur e", Employeur.class).getResultList();
        em.close();
        return liste;
    }
}