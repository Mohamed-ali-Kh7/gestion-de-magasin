package entity;

import java.util.Date;

public class Product {

     private int ID;
     private String Label;
     private String Marque;
     private double Prix;
     private Date dateExpiration;

    //constructeur par defaut
    public Product() {
        this.ID = 0;
        this.Label = "inconnu";
        this.Marque = "inconnu";
        this.Prix = 0;
        this.dateExpiration = null;
    }

    //constructeur par configuré avec 4 parametres
    public Product(int id, String label, String marque, double prix) {
        ID = id;
        Label = label;
        Marque = marque;
        Prix = prix;
        this.dateExpiration = null;
    }

    public int getID() { return ID; }
    public void setID(int ID) { this.ID = ID; }

    public String getLabel() { return Label; }
    public void setLabel(String label) { this.Label = label; }

    public String getMarque() { return Marque; }
    public void setMarque(String marque) { this.Marque = marque; }

    public double getPrix() { return Prix; }
    public void setPrix(double prix) { this.Prix = prix; }

    public Date getDateExpiration() { return dateExpiration; }
    public void setDateExpiration(Date dateExpiration) { this.dateExpiration = dateExpiration; }


    // Méthode comparer avec un seul produit (a)
    public boolean comparer(Product autreProduit) {
        if (autreProduit == null) return false;
        return this.ID == autreProduit.ID &&
                this.Label.equals(autreProduit.Label) &&
                this.Prix == autreProduit.Prix;
    }

    // Méthode comparer avec deux produits (b) - STATIC
    public static boolean comparer(Product p1, Product p2) {
        if (p1 == null || p2 == null) return false;
        return p1.ID == p2.ID &&
                p1.Label.equals(p2.Label) &&
                p1.Prix == p2.Prix;
    }

    public void afficheInfos() {
        System.out.println("ID: " + ID + ", Label: "+ Label +", Marque :" + Marque + ", Prix : " + Prix + ", Date Expiration: " + dateExpiration );
    }

    public String toString() {
        return "Produit{" +
                "ID=" + ID +
                ", Label='" + Label + '\'' +
                ", Marque='" + Marque + '\'' +
                ", Prix=" + Prix +
                ", DateExpiration=" + dateExpiration +
                '}';
    }
}


