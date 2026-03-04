package org.example.esocial.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "declarations")
public class Declaration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int mois;
    private int annee;
    private Double montantTotal;

    @ManyToOne
    @JoinColumn(name = "employeur_id", nullable = false)
    private Employeur employeur;

    @OneToMany(mappedBy = "declaration", cascade = CascadeType.ALL)
    private List<Cotisations> cotisations = new ArrayList<>();

    public Declaration() {}

    public Declaration(int mois, int annee, Employeur employeur) {
        this.mois = mois;
        this.annee = annee;
        this.employeur = employeur;
        this.montantTotal = 0.0;
    }

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getMois() { return mois; }
    public void setMois(int mois) { this.mois = mois; }
    public int getAnnee() { return annee; }
    public void setAnnee(int annee) { this.annee = annee; }
    public Double getMontantTotal() { return montantTotal; }
    public void setMontantTotal(Double montantTotal) { this.montantTotal = montantTotal; }
    public Employeur getEmployeur() { return employeur; }
    public void setEmployeur(Employeur employeur) { this.employeur = employeur; }
    public List<Cotisations> getCotisations() { return cotisations; }
    public void setCotisations(List<Cotisations> cotisations) { this.cotisations = cotisations; }
}