package org.example.esocial.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employeurs")
public class Employeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String raisonSociale;
    private String secteurActivite;
    public Employeur() {}

    public Employeur(String raisonSociale, String secteurActivite) {
        this.raisonSociale = raisonSociale;
        this.secteurActivite = secteurActivite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getSecteurActivite() {
        return secteurActivite;
    }

    public void setSecteurActivite(String secteurActivite) {
        this.secteurActivite = secteurActivite;
    }
}