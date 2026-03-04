package org.example.esocial.service;

import jakarta.persistence.EntityManager;
import org.example.esocial.model.Assure;
import org.example.esocial.model.Cotisations;
import org.example.esocial.model.Declaration;
import org.example.esocial.util.DBConnection;
import java.util.List;

public class CotisationService {

    // Taux de cotisation (Exemple : 20% patronal, 7% salarial)
    private static final double TAUX_PATRONAL = 0.20;
    private static final double TAUX_SALARIAL = 0.07;

    public void genererCotisation(int assureId, int declarationId) {
        EntityManager em = DBConnection.getEntityManager();
        try {
            em.getTransaction().begin();

            Assure assure = em.find(Assure.class, assureId);
            Declaration dec = em.find(Declaration.class, declarationId);

            if (assure != null && dec != null) {
                // Calcul automatique selon le salaire de l'assuré
                double patronal = assure.getSalaireMensuel() * TAUX_PATRONAL;
                double salarial = assure.getSalaireMensuel() * TAUX_SALARIAL;

                Cotisations c = new Cotisations(patronal, salarial, dec, assure);
                em.persist(c);
            }

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<Cotisations> listerParDeclaration(int declarationId) {
        EntityManager em = DBConnection.getEntityManager();
        try {
            return em.createQuery("SELECT c FROM Cotisations c WHERE c.declaration.id = :decId", Cotisations.class)
                    .setParameter("decId", declarationId)
                    .getResultList();
        } finally {
            em.close();
        }
    }
}