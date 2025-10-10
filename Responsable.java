package com.gestion.employee;

public class Responsable extends Employee {
    private  double prime;

    public Responsable() {
        this.nom = nom;
        this.adresse = "inconnu";
        this.nbrHeures = 0;
        this.prime = prime;
    }

    public Responsable(String nom, String adresse, int nbrHeures,  double prime) {
        super(nom, adresse, nbrHeures);
        this.prime = prime;
    }
}
