package org.example.esocial.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cotisations")
public class Cotisations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // 'id: int'

    @Column(name = "cotisation_patronale")
    private Double cotisationPatronale; // 'cotisationPatronale: Double'

    @Column(name = "cotisation_salariale")
    private Double cotisationSalariale; // 'cotisationSalariae: Double'

    // Relation vers la Déclaration (FK_declaration_id)
    @ManyToOne
    @JoinColumn(name = "declaration_id", nullable = false)
    private Declaration declaration; //

    // Relation vers l'Assuré (FK_assure_id)
    @ManyToOne
    @JoinColumn(name = "assure_id", nullable = false)
    private Assure assure; //

    public Cotisations() {}

    public Cotisations(Double cotisationPatronale, Double cotisationSalariale, Declaration declaration, Assure assure) {
        this.cotisationPatronale = cotisationPatronale;
        this.cotisationSalariale = cotisationSalariale;
        this.declaration = declaration;
        this.assure = assure;
    }

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Double getCotisationPatronale() { return cotisationPatronale; }
    public void setCotisationPatronale(Double cotisationPatronale) { this.cotisationPatronale = cotisationPatronale; }

    public Double getCotisationSalariale() { return cotisationSalariale; }
    public void setCotisationSalariale(Double cotisationSalariale) { this.cotisationSalariale = cotisationSalariale; }

    public Declaration getDeclaration() {
        return declaration;
    }

    public void setDeclaration(Declaration declaration) {
        this.declaration = declaration;
    }

    public Assure getAssure() { return assure; }
    public void setAssure(Assure assure) { this.assure = assure; }
}