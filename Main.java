import com.gestion.employee.Caissier;
import com.gestion.employee.Employee;
import com.gestion.employee.Responsable;
import com.gestion.employee.Vendeur;
import com.gestion.magasin.Magasin;
import entity.Product;

import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello in our Store!\n");

        Product p = new Product();
        Product p1 = new Product(1021, ", Lait", ", Delice",0);
        Product p1Duplique = new Product(1021, ", Lait", ", Delice",0);
        Product p2 = new Product(2510, ", Yaourt", ", Vitalait", 0);
        Product p3 = new Product(3250, ", Tomate", ", Sicam", 1.200);

        System.out.println("=== Liste des produits ===");
        p.afficheInfos();
        p1.afficheInfos();
        p2.afficheInfos();
        p3.afficheInfos();

        System.out.println("=== Edite prix product 1 ===");
        p2.setPrix(0.700);
        p2.afficheInfos();

        System.out.println("=== Edite prix product 2===");
        p2.setPrix(1.500);
        p2.afficheInfos();

        System.out.println("\n=== Avec toString ===");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        // 8. Ajouter date d’expiration
        p1.setDateExpiration(new Date(125, 9, 20));
        p2.setDateExpiration(new Date(125, 11, 5));
        p3.setDateExpiration(new Date(126, 0, 15));

        System.out.println("\n=== Produits avec date d’expiration ===");
        p1.afficheInfos();
        p2.afficheInfos();
        p3.afficheInfos();

        System.out.println("\n ************************* Magasin ********************\n");

        Magasin m1 = new Magasin(2, "Menzah 6");

        // Ajouter produits a m1
        m1.ajouterProduit(p1);
        m1.ajouterProduit(p1Duplique);
        m1.ajouterProduit(p2);
        m1.ajouterProduit(p3);


        Magasin m2 = new Magasin(1, "Tunis");
        // Ajouter produits
        m2.ajouterProduit(p1);
        m2.ajouterProduit(p2);

        System.out.println("\n ************************* Employee ********************\n");

        //  Création des employés  pour la 1er magasin
        Caissier caissier1Monoprix = new Caissier("Salah", "Tunis", 145, 5);
        Caissier caissier2Carrefour = new Caissier("Fatma Ben Salah", "Ariana", 175, 2);
        Vendeur vendeurCarrefour = new Vendeur("Mohamed Dridi", "Ben Arous", 160, 5000);
        Responsable responsableMonoprix = new Responsable("Nadia Fersi", "Bardo", 175, 250);

        System.out.println("\n============== ajouter les employées au magasin 1 ===============\n");
        m1.ajouterEmploye(caissier1Monoprix);
        m1.ajouterEmploye(caissier2Carrefour);
        m1.ajouterEmploye(vendeurCarrefour);
        m1.ajouterEmploye(responsableMonoprix);

        //  Création des employés  pour la 2eme magasin
        Caissier caissier3Mg = new Caissier("moncef", "Bardo", 139, 7);
        Vendeur vendeur1Mg = new Vendeur("Leila", "Megrine", 75, 456);
        Vendeur vendeur2Carrefour = new Vendeur("Mohamed", "Ben Arous", 150, 5000);
        Vendeur vendeur3Monoprix = new Vendeur("Saber", "Zaghoun", 178, 5000);
        Responsable responsable2Mg = new Responsable("Rafik", "Nabeul", 6, 1000);

        System.out.println("\n============== ajouter les employées au magasin 2 ===============\n");
        m2.ajouterEmploye(caissier3Mg);
        m2.ajouterEmploye(vendeur1Mg);
        m2.ajouterEmploye(vendeur2Carrefour);
        m2.ajouterEmploye(vendeur3Monoprix);
        m2.ajouterEmploye(responsable2Mg);

        System.out.println("\n============================= affiche les infos de magasin 1 avec la function d'affichage  ==============================\n");

        m1.afficheMagasinInfos();

        System.out.println("\n============================= affiche les infos de magasin 1 avec ToString  ==============================\n");

        System.out.println(m2);

        // afficher le total des magasin creés
        System.out.println("\n \n [INFO] Nombre total de magasins : " + Magasin.getTotalMagasin() + " \n");

        // afficher le total des produits dans tt les magasins
        System.out.println("\n [INFO] Nombre total de produits : " + Magasin.getTotalProduits() + " \n");

        // afficher le total des employees dans tt les magasins
        System.out.println("\n [INFO] Nombre total de employees : " + Magasin.getNbTotalEmplyees() + " \n \n");

        System.out.println("===============  méthode comparer ==============\n");

        // Test méthode comparer avec un paramètre
        System.out.println("p1.comparer(p1Duplique) : " + p1.comparer(p1Duplique)); //true

        // Test méthode comparer static avec deux paramètres
        System.out.println("Comparer(p1, p2) : " + Product.comparer(p1, p2)); // false

        System.out.println("\n===============  Test méthode rechercher ==============\n");

        Product p4 = new Product(3250, ", Tomate", ", Sicam", 1.200); // Dupliqué
        m1.ajouterProduit(p4); //  Échoue - produit déjà existant


        System.out.println("\n===============  Test méthode affichage pour les enfants de Employee ==============\n");


        Responsable r1 = new Responsable( "Amine", "Tunis", 170, 200);
        Caissier c1 = new Caissier( "Sami", "manouba", 200,1);
        Vendeur v1 = new Vendeur("Rania", "ben arous ", 80,0.8); // 80%
        Employee e = new Vendeur("Rami", "ben arous ", 80,0.8); // 80%
        if (e instanceof Vendeur) { // sécurité
            Vendeur v = (Vendeur) e; // downcast
            System.out.println("Taux de vente : " + v.getTauxDeVente());
        }

        r1.afficherSalaire();
        c1.afficherSalaire();
        v1.afficherSalaire();
    }
}