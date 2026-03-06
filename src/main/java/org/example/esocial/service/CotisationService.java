package org.example.esocial.service;

import jakarta.persistence.EntityManager;
import org.example.esocial.model.Assure;
import org.example.esocial.model.Cotisations;
import org.example.esocial.model.Declaration;
import org.example.esocial.util.DBConnection;
import java.util.List;

public class CotisationService {


    private static final double TAUX_PATRONAL = 0.20;
    private static final double TAUX_SALARIAL = 0.07;

    private static final double PLAFOND_CNSS = 6000.0;

    public void genererCotisation(int assureId, int declarationId) {
        EntityManager em = DBConnection.getEntityManager();
        try {
            em.getTransaction().begin();
            Assure assure = em.find(Assure.class, assureId);
            Declaration dec = em.find(Declaration.class, declarationId);

            if (assure != null && dec != null) {
                double salaireCotisable = Math.min(assure.getSalaireMensuel(), PLAFOND_CNSS);

                double patronal = salaireCotisable * TAUX_PATRONAL;
                double salarial = salaireCotisable * TAUX_SALARIAL;

                Cotisations c = new Cotisations(patronal, salarial, dec, assure);
                em.persist(c);

                double nouveauTotal = (dec.getMontantTotal() != null ? dec.getMontantTotal() : 0.0) + patronal
                        + salarial;
                dec.setMontantTotal(nouveauTotal);
                em.merge(dec);
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