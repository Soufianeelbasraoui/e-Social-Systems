package org.example.esocial.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employeur")
public class Employeur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "raison_sociale", nullable = false)
    private String raisonSociale;

    @Column(name = "secteur_activite", nullable = false)
    private String secteurActivite;

    // CORRECTION 1 : Changement de FetchType.LAZY à EAGER
    // Cela permet d'afficher l'historique dans la JSP sans erreur 500
    @OneToMany(mappedBy = "employeur", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Declaration> declarations = new ArrayList<>();

    // CORRECTION 2 : Changement de FetchType.LAZY à EAGER
    // Cela permet d'afficher la liste des assurés dans la JSP sans erreur 500
    @OneToMany(mappedBy = "employeur", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Assure> assures = new ArrayList<>();

    public Employeur() {
    }

    public Employeur(String raisonSociale, String secteurActivite) {
        this.raisonSociale = raisonSociale;
        this.secteurActivite = secteurActivite;
    }

    // Getters et Setters (inchangés)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getRaisonSociale() { return raisonSociale; }
    public void setRaisonSociale(String raisonSociale) { this.raisonSociale = raisonSociale; }

    public String getSecteurActivite() { return secteurActivite; }
    public void setSecteurActivite(String secteurActivite) { this.secteurActivite = secteurActivite; }

    public List<Assure> getAssures() { return assures; }
    public void setAssures(List<Assure> assures) { this.assures = assures; }

    public List<Declaration> getDeclarations() { return declarations; }
    public void setDeclarations(List<Declaration> declarations) { this.declarations = declarations; }
}