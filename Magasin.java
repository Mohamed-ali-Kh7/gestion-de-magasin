package Magasin;
import entity.Product;

public class Magasin {
    int ID;
    String adresse;
    int capacite;
    Product[] produits;
    int nbProduits ;

    public Magasin() {
        this.ID = 0;
        this.adresse="inconnu";
        this.capacite=50;
        this.produits= new Product[this.capacite];
        this.nbProduits = 0;
    }

    public Magasin(int ID, String adresse, int capacite) {
        this.ID = ID;
        this.adresse = adresse;
        this.capacite = capacite;
        this.produits = new Product[capacite];
        this.nbProduits = 0;

    }

    public void afficheMagasinInfos() {
        System.out.println("ID: " + ID + ", Adresse: "+ adresse +", Capacité : " + capacite +" Nombre produits : "+ nbProduits);
        System.out.println("Liste des produits de cette magasin :");
        for (int i = 0; i < nbProduits; i++) {
            System.out.println("   -"+ i + "- " +produits[i]);
        }

    }

    public boolean ajouterProduit(Product p) {
        if (nbProduits < this.capacite) {
            this.produits[nbProduits] = p;
            nbProduits++;
            return true;
        }else  {
            System.out.println("!! Capacité de magazin atteinte");
            return false;
        }
    }

}
