package com.gestion.employee;

public class Caissier extends Employee {
    private int numeroDeCaisse ;

    public Caissier() {
        super();
        this.numeroDeCaisse = 0;
    }

    public Caissier(String nom, String adresse, int nbrHeures, int numeroDeCaisse) {
        super(nom, adresse, nbrHeures);
        this.numeroDeCaisse = numeroDeCaisse;
    }

    @Override
    public double calculerSalaire() {
        if (nbrHeures <= 180) {
            return nbrHeures * 5;
        } else {
            int heuresSupp = nbrHeures - 180;
            return (180 * 5) + (heuresSupp * 5 * 1.15);
        }
    }
}
