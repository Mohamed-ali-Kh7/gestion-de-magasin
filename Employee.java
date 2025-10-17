package com.gestion.employee;

public abstract class Employee {
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

    public String toString() {
        return "Employee{" +
                "ID=" + id +
                ", Nom='" + nom + '\'' +
                ", Adresse='" + adresse + '\'' +
                ", Nom Heures=" + nbrHeures +
                '}';
    }

    public void afficherSalaire() {
        System.out.println("Employé : " + nom + " | Salaire : " + calculerSalaire() + " DT");
    }

    public abstract double calculerSalaire() ;

    // Getters
    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getAdresse() { return adresse; }
    public int getNbrHeures() { return nbrHeures; }


}
