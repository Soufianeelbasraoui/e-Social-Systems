package org.example.esocial.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "assures")
public class Assure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nom;

    @Column(name = "salaire_mensuel")
    private Double salaireMensuel;

    @ManyToOne
    @JoinColumn(name = "employeur_id", nullable = false)
    private Employeur employeur;

    @OneToMany(mappedBy = "assure", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Cotisations> cotisations = new ArrayList<>();

    public Assure() {
    }

    public Assure(String nom, Double salaireMensuel, Employeur employeur) {
        this.nom = nom;
        this.salaireMensuel = salaireMensuel;
        this.employeur = employeur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getSalaireMensuel() {
        return salaireMensuel;
    }

    public void setSalaireMensuel(Double salaireMensuel) {
        this.salaireMensuel = salaireMensuel;
    }

    public Employeur getEmployeur() {
        return employeur;
    }

    public void setEmployeur(Employeur employeur) {
        this.employeur = employeur;
    }

    public List<Cotisations> getCotisations() {
        return cotisations;
    }

    public void setCotisations(List<Cotisations> cotisations) {
        this.cotisations = cotisations;
    }
}