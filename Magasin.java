package com.gestion.magasin;
import com.gestion.employee.Employee;
import entity.Product;

public class Magasin {
    private int ID;
    private String adresse;
    private final int CAPACITE=50;
    private Product[] produits = new Product[this.CAPACITE]; // creer un tab pour tt les les instances de magasin
    private int nbProduits = 0 ;
    private final int CAPACITE_EM=50;
    private Employee[] employes =  new Employee[this.CAPACITE_EM];
    private int nbEmployes;

    private static int nbMagasin = 0; //commune à toutes les instances
    private static int nbTotalProduits = 0;

    public Magasin() {
        ID = 0;
        adresse= null;
        nbProduits = 0;
        nbEmployes = 0;
        nbMagasin++;
        System.out.println("\n[INFO] Magasin " + this.ID + " creé !!");
        System.out.println("[INFO] Total des magasins : " + nbMagasin + "\n");
        //le tab va creer automatiquement
        // snn , je peux creer manualement avec une capacité donné 'this.produits = new Product[capacite];'

    }

    public Magasin(int ID, String adresse) {
        this.ID = ID;
        this.adresse = adresse;
        nbMagasin++;
        System.out.println("\n[INFO] Magasin " + this.ID + " creé !!");
        System.out.println("[INFO] Total des magasins : " + nbMagasin + "\n");

    }

    public void afficheMagasinInfos() {
        System.out.println("ID: " + ID + ", Adresse: "+ adresse +", Capacité : " + CAPACITE +", Nombre produits : "+ nbProduits);
        System.out.println("Liste des produits de cette magasin :");

        for (int i = 0; i < nbProduits; i++) {
            if(produits[i] != null){
                System.out.println("   - " + (i + 1) + " " + produits[i] + "\n");
            }

        }

    }

    // Méthode pour ajouter un employé
    public boolean ajouterEmploye(Employee employe) {
        if (nbEmployes < CAPACITE_EM) {
            employes[nbEmployes] = employe;
            nbEmployes++;
            System.out.println("[INFO] Employé " + employe.getNom() + " ajouté au magasin " + adresse);
            return true;
        } else {
            System.out.println("[ERREUR] Magasin " + adresse + " a atteint le maximum d'employés (20)");
            return false;
        }
    }

    @Override
    public String toString() {
        String str = "L'ensemble des produits :\n";
        for (int i = 0; i < nbProduits; i++) {
            str += produits[i] + "\n";
        }

        return "Identifiant : " + ID
                + " | Adresse : " + adresse
                + "\n" + str;
    }


    public boolean ajouterProduit(Product p) {
        // Vérifier d'abord si le produit existe déjà dans le magasin
        if (chercherProduit(p)) {
            System.out.println("[ERREUR] Le produit " + p.getLabel() + " existe déjà dans le magasin " + ID);
            return false;
        }

        // Ensuite vérifier la capacité
        if (nbProduits < this.CAPACITE) {
            this.produits[nbProduits] = p;
            nbProduits++;
            nbTotalProduits++;

            System.out.println("\n[INFO] Produit ajouté au magasin " + ID);
            System.out.println("[INFO] Produits dans ce magasin : " + nbProduits + "\n");
            return true;
        } else {
            System.out.println("[ERREUR] Magasin " + ID + " plein !");
            return false;
        }
    }

    //  Méthode pour chercher un produit
    public boolean chercherProduit(Product produitRecherche) {
        if (produitRecherche == null) return false;

        for (int i = 0; i < nbProduits; i++) {
            // Utilisation de la méthode comparer avec un paramètre
            if (produits[i].comparer(produitRecherche)) {
                return true;
            }
        }
        return false;
    }



    //pour les compteur locaux de chaque magasin
    public int getNbProduits() {
        return nbProduits;
    }

    public int getNbEmployes() {
        return nbEmployes;
    }

    //pour les compteur globaux de tous les produits et les magasin

    public static int getTotalProduits() {
        return nbTotalProduits;
    }

    public static int getTotalMagasin() {
        return nbMagasin;
    }

}
