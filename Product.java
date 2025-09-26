package entity;

import java.util.Date;

public class Product {

     int ID;
     String Label;
     String Marque;
     double Prix;
     Date dateExpiration;

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


