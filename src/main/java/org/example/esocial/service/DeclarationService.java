package org.example.esocial.service;

import jakarta.persistence.EntityManager;
import org.example.esocial.model.Declaration;
import org.example.esocial.model.Employeur;
import org.example.esocial.util.DBConnection;

import java.util.List;

public class DeclarationService {

    public void creerDeclaration(int mois, int annee, int employeurId) {
        if (declarationExiste(employeurId, mois, annee)) {
            return;
        }
        EntityManager em = DBConnection.getEntityManager();
        try {
            em.getTransaction().begin();
            Employeur emp = em.find(Employeur.class, employeurId);
            if (emp != null) {
                Declaration d = new Declaration(mois, annee, emp);
                em.persist(d);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<Declaration> listerParEmployeur(int employeurId) {
        EntityManager em = DBConnection.getEntityManager();
        try {
            return em.createQuery(
                    "SELECT d FROM Declaration d WHERE d.employeur.id = :empId",
                    Declaration.class)
                    .setParameter("empId", employeurId)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public boolean declarationExiste(int employeurId, int mois, int annee) {
        EntityManager em = DBConnection.getEntityManager();
        try {
            List<Declaration> res = em.createQuery(
                    "SELECT d FROM Declaration d WHERE d.employeur.id = :empId AND d.mois = :mois AND d.annee = :annee",
                    Declaration.class)
                    .setParameter("empId", employeurId)
                    .setParameter("mois", mois)
                    .setParameter("annee", annee)
                    .getResultList();
            return !res.isEmpty();
        } finally {
            em.close();
        }
    }

    public List<Declaration> listerToutesDeclarations() {
        EntityManager em = DBConnection.getEntityManager();
        try {
            return em.createQuery("SELECT d FROM Declaration d JOIN FETCH d.employeur", Declaration.class).getResultList();
        } finally {
            em.close();
        }
    }

    public Declaration trouverParId(int id) {
        EntityManager em = DBConnection.getEntityManager();
        try {
            return em.find(Declaration.class, id);
        } finally {
            em.close();
        }
    }
}
