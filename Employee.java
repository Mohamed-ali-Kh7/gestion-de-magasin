package com.gestion.employee;

public class Employee {
    protected  int id;
    protected  String nom;
    protected  String adresse;
    protected  int nbrHeures;
    protected  static int nextID = 0;

    public Employee() {
        id = nextID++;
        nom = "Employee";
        adresse = "inconnu";
        nbrHeures = 0;
    }

    public Employee( String nom, String adresse, int nbrHeures) {
        this.id = nextID++;;
        this.nom = nom;
        this.adresse = adresse;
        this.nbrHeures = nbrHeures;
    }

    // Getters
    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getAdresse() { return adresse; }
    public int getNbrHeures() { return nbrHeures; }


}
