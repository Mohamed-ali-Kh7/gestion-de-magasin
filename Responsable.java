package com.gestion.employee;

public class Responsable extends Employee {
    private  double prime;

    public Responsable() {
        this.prime = prime;
    }

    public Responsable(String nom, String adresse, int nbrHeures,  double prime) {
        super(nom, adresse, nbrHeures);
        this.prime = prime;
    }

    @Override
    public double calculerSalaire() {
        double salaireBase;
        if (nbrHeures <= 160) {
            salaireBase = nbrHeures * 10;
        } else {
            int heuresSupp = nbrHeures - 160;
            salaireBase = (160 * 10) + (heuresSupp * 10 * 1.2);
        }
        return salaireBase + prime;
    }
}
