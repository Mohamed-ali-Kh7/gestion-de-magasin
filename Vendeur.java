package com.gestion.employee;

public class Vendeur  extends Employee {
    private double tauxDeVente;



    public Vendeur( String nom, String adresse, int nbrHeures, double tauxDeVente) {
        super(nom, adresse, nbrHeures);
        this.tauxDeVente = tauxDeVente;
    }

    @Override
    public double calculerSalaire() {
        return 450 * tauxDeVente;
    }


    public double getTauxDeVente() {
        return tauxDeVente;
    }
}
