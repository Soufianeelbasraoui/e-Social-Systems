package org.example.esocial.service;

import jakarta.persistence.EntityManager;
import org.example.esocial.model.Assure;
import org.example.esocial.model.Employeur;
import org.example.esocial.util.DBConnection;

import java.util.List;

public class AssureService {

    public void ajouterAssure(String nom, double salaire, int employeurId) {
        EntityManager em = DBConnection.getEntityManager();
        try {
            em.getTransaction().begin();
            Employeur emp = em.find(Employeur.class, employeurId);
            Assure a = new Assure();
            a.setNom(nom);
            a.setSalaireMensuel(salaire);
            a.setEmployeur(emp);
            em.persist(a);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void modifierSalaire(int id, double salaire) {
        EntityManager em = DBConnection.getEntityManager();
        try {
            em.getTransaction().begin();
            Assure a = em.find(Assure.class, id);
            if (a != null) {
                a.setSalaireMensuel(salaire);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<Assure> listerTout() {
        EntityManager em = DBConnection.getEntityManager();
        try {
            return em.createQuery(
                    "SELECT a FROM Assure a JOIN FETCH a.employeur",
                    Assure.class).getResultList();
        } finally {
            em.close();
        }
    }

    public List<Assure> listerParEmployeur(int employeurId) {
        EntityManager em = DBConnection.getEntityManager();
        try {
            return em.createQuery(
                    "SELECT a FROM Assure a WHERE a.employeur.id = :id",
                    Assure.class)
                    .setParameter("id", employeurId)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public Assure trouverParId(int id) {
        EntityManager em = DBConnection.getEntityManager();
        try {
            return em.find(Assure.class, id);
        } finally {
            em.close();
        }
    }

}