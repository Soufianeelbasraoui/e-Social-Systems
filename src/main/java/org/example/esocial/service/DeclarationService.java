package org.example.esocial.service;

import jakarta.persistence.EntityManager;
import org.example.esocial.model.Declaration;
import org.example.esocial.model.Employeur;
import org.example.esocial.util.DBConnection;
import java.util.List;

public class DeclarationService {

    public void creerDeclaration(int mois, int annee, int employeurId) {
        EntityManager em = DBConnection.getEntityManager();
        try {
            em.getTransaction().begin();
            Employeur emp = em.find(Employeur.class, employeurId);
            if (emp != null) {
                Declaration d = new Declaration(mois, annee, emp);
                em.persist(d);
            }
            em.getTransaction().commit();
        } finally { em.close(); }
    }

    public List<Declaration> listerParEmployeur(int employeurId) {
        EntityManager em = DBConnection.getEntityManager();
        try {
            return em.createQuery("SELECT d FROM Declaration d WHERE d.employeur.id = :empId", Declaration.class)
                    .setParameter("empId", employeurId)
                    .getResultList();
        } finally { em.close(); }
    }
}