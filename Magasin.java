package com.gestion.magasin;

import com.gestion.employee.Employee;
import entity.Product;
import gestionException.MagasinPleinException;
import gestionException.PrixNegatifException;

public class Magasin {
    private int ID;
    private String adresse;
    private final int CAPACITE = 1;
    private Product[] produits = new Product[this.CAPACITE]; // tableau des produits
    private int nbProduits = 0;

    private final int CAPACITE_EM = 50;
    private Employee[] employes = new Employee[this.CAPACITE_EM];
    private int nbEmployes = 0;

    private static int nbMagasin = 0; // commune à toutes les instances
    private static int nbTotalProduits = 0;
    private static int nbTotalEmplyees = 0;

    // Constructeur par défaut
    public Magasin() {
        ID = 0;
        adresse = null;
        nbProduits = 0;
        nbEmployes = 0;
        nbMagasin++;
        System.out.println("\n[INFO] Magasin " + this.ID + " créé !!");
        System.out.println("[INFO] Total des magasins : " + nbMagasin + "\n");
    }

    // Constructeur paramétré
    public Magasin(int ID, String adresse) {
        this.ID = ID;
        this.adresse = adresse;
        nbMagasin++;
        System.out.println("\n[INFO] Magasin " + this.ID + " créé !!");
        System.out.println("[INFO] Total des magasins : " + nbMagasin + "\n");
    }

    // Affichage complet du magasin
    public void afficheMagasinInfos() {
        System.out.println("ID: " + ID + ", Adresse: " + adresse +
                ", Capacité : " + CAPACITE +
                ", Nombre produits : " + nbProduits +
                ", Nombre employés : " + nbEmployes);

        System.out.println("\nListe des produits de ce magasin : ");
        for (int i = 0; i < nbProduits; i++) {
            if (produits[i] != null) {
                System.out.println("   - " + (i + 1) + " " + produits[i] + "\n");
            }
        }

        System.out.println("Liste des employés dans ce magasin :");
        for (int i = 0; i < nbEmployes; i++) {
            if (employes[i] != null) {
                System.out.println("   - " + (i + 1) + " " + employes[i] + "\n");
            }
        }
    }

    @Override
    public String toString() {
        String strP = "L'ensemble des Produits :\n";
        String strE = "L'ensemble des Employés :\n";

        for (int i = 0; i < nbProduits; i++) {
            strP += produits[i] + "\n";
        }
        for (int i = 0; i < nbEmployes; i++) {
            strE += employes[i] + "\n";
        }

        return "Identifiant : " + ID
                + " | Adresse : " + adresse
                + "\n" + strP
                + "\n" + strE;
    }

    // Méthode pour ajouter un employé
    public boolean ajouterEmploye(Employee employe) {
        if (nbEmployes < CAPACITE_EM) {
            employes[nbEmployes] = employe;
            nbEmployes++;
            nbTotalEmplyees++;
            System.out.println("[INFO] Employé " + employe.getNom() + " ajouté au magasin " + adresse);
            return true;
        } else {
            System.out.println("[ERREUR] Magasin " + adresse + " a atteint le maximum d'employés (" + CAPACITE_EM + ")");
            return false;
        }
    }

    // Méthode pour ajouter un produit
    public boolean ajouterProduit(Product p) throws PrixNegatifException, MagasinPleinException {
        // Vérifier si le produit existe déjà
        if (chercherProduit(p)) {
            System.out.println("[ERREUR] Le produit " + p.getLabel() + " existe déjà dans le magasin " + ID);
            return false;
        }

        // Vérifier la capacité
        if (nbProduits >= CAPACITE) {
            throw new MagasinPleinException("Erreur : Le magasin est plein !");
        }

        // Vérifier le prix
        if (p.getPrix() < 0) {
            throw new PrixNegatifException("Erreur : Le prix doit être positif !");
        }

        produits[nbProduits] = p;
        nbProduits++;
        nbTotalProduits++;

        System.out.println("\n[INFO] Produit ajouté au magasin " + ID);
        System.out.println("[INFO] Produits dans ce magasin : " + nbProduits + "\n");
        return true;
    }

    // Méthode pour chercher un produit
    public boolean chercherProduit(Product produitRecherche) {
        if (produitRecherche == null) {
            return false;
        }

        for (int i = 0; i < nbProduits; i++) {
            // On suppose que la classe Product a une méthode comparer()
            if (produits[i].comparer(produitRecherche)) {
                return true;
            }
        }
        return false;
    }

    // Getters pour les compteurs locaux
    public int getNbProduits() {
        return nbProduits;
    }

    public int getNbEmployes() {
        return nbEmployes;
    }

    // Getters pour les compteurs globaux
    public static int getTotalProduits() {
        return nbTotalProduits;
    }

    public static int getTotalMagasin() {
        return nbMagasin;
    }

    public static int getNbTotalEmplyees() {
        return nbTotalEmplyees;
    }
}
