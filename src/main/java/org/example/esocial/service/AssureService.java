package org.example.esocial.service;

import jakarta.persistence.EntityManager;
import org.example.esocial.model.Assure;
import org.example.esocial.model.Employeur;
import org.example.esocial.util.DBConnection;
import java.util.List;

public class AssureService {

    // Ajouter un assuré
    public void ajouterAssure(String nom, Double salaire, int employeurId) {
        EntityManager em = DBConnection.getEntityManager();
        try {
            em.getTransaction().begin();
            Employeur emp = em.find(Employeur.class, employeurId);
            if (emp != null) {
                Assure a = new Assure(nom, salaire, emp);
                em.persist(a);
            }
            em.getTransaction().commit();
        } finally { em.close(); }
    }

    // Modifier le salaire
    public void modifierSalaire(int id, Double nouveauSalaire) {
        EntityManager em = DBConnection.getEntityManager();
        try {
            em.getTransaction().begin();
            Assure a = em.find(Assure.class, id);
            if (a != null) { a.setSalaireMensuel(nouveauSalaire); }
            em.getTransaction().commit();
        } finally { em.close(); }
    }

    // Consulter tous les assurés
    public List<Assure> listerTout() {
        EntityManager em = DBConnection.getEntityManager();
        try {
            return em.createQuery("SELECT a FROM Assure a", Assure.class).getResultList();
        } finally { em.close(); }
    }

    // Consulter les assurés d'un employeur
    public List<Assure> listerParEmployeur(int employeurId) {
        EntityManager em = DBConnection.getEntityManager();
        try {
            return em.createQuery("SELECT a FROM Assure a WHERE a.employeur.id = :empId", Assure.class)
                    .setParameter("empId", employeurId)
                    .getResultList();
        } finally { em.close(); }
    }
}