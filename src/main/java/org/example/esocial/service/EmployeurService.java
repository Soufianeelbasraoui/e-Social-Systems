package org.example.esocial.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.esocial.model.Assure;
import org.example.esocial.model.Employeur;
import org.example.esocial.util.DBConnection;
import java.util.List;

public class EmployeurService {

    // 1. Ajouter un employeur
    public void enregistrerEmployeur(String nom, String secteur) {
        if (nom != null && !nom.trim().isEmpty()) {
            EntityManager em = DBConnection.getEntityManager();
            EntityTransaction et = em.getTransaction();
            try {
                et.begin();
                Employeur e = new Employeur(nom, secteur);
                em.persist(e);
                et.commit();
            } catch (Exception ex) {
                if (et.isActive()) et.rollback();
                ex.printStackTrace();
            } finally {
                em.close();
            }
        }
    }

    // 2. Consulter la liste des employeurs
    public List<Employeur> listerTout() {
        EntityManager em = DBConnection.getEntityManager();
        try {
            return em.createQuery("SELECT e FROM Employeur e", Employeur.class).getResultList();
        } finally {
            em.close();
        }
    }

    // 3. Consulter un employeur par ID
    public Employeur trouverParId(int id) {
        EntityManager em = DBConnection.getEntityManager();
        try {
            Employeur emp = em.find(Employeur.class, id);
            if (emp != null) {
                // On force le chargement des deux listes
                emp.getAssures().size();
                emp.getDeclarations().size();
            }
            return emp;
        } finally {
            em.close();
        }
    }
    public void associerEmploye(String nomAssure, Double salaire, int employeurId) {
        EntityManager em = DBConnection.getEntityManager();
        try {
            em.getTransaction().begin();
            // On récupère l'employeur existant
            Employeur emp = em.find(Employeur.class, employeurId);
            if (emp != null) {
                // On crée l'assuré lié à cet employeur
                Assure assure = new Assure(nomAssure, salaire, emp);
                em.persist(assure);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}