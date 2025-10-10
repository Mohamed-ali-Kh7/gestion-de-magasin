package com.gestion.employee;

public class Vendeur  extends Employee {
    private double tauxDeVente;

    public Vendeur( ) {
        this.nom = "Vendeur";
        this.adresse = "inconnu";
        this.nbrHeures = nbrHeures;
        this.tauxDeVente = 0;

    }

    public Vendeur( String nom, String adresse, int nbrHeures, double tauxDeVente) {
        super(nom, adresse, nbrHeures);
        this.tauxDeVente = tauxDeVente;
    }

}
