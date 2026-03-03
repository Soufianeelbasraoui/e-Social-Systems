package org.example.esocial.service;

import org.example.esocial.DAO.EmployeurDAO;
import org.example.esocial.model.Employeur;
import java.util.List;

public class EmployeurService {
    private EmployeurDAO dao = new EmployeurDAO();

    public void enregistrerEmployeur(String nom, String secteur) {
        if (nom != null && !nom.isEmpty()) {
            Employeur e = new Employeur(nom, secteur);
            dao.save(e);
        }
    }

    public List<Employeur> listerTout() {
        return dao.findAll();
    }
}