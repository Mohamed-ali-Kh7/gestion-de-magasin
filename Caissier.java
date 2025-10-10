package com.gestion.employee;

public class Caissier extends Employee {
    private int numeroDeCaisse ;

    public Caissier() {
        this.nom = "Caissier";
        this.adresse = "inconnu";
        this.nbrHeures = 0;
        this.numeroDeCaisse = 0;
    }

    public Caissier(String nom, String adresse, int nbrHeures, int numeroDeCaisse) {
        super(nom, adresse, nbrHeures);
        this.numeroDeCaisse = numeroDeCaisse;
    }
}
