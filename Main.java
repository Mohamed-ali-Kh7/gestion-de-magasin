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
        Product p2 = new Product(2510, ", Yaourt", ", Vitalait", 0);
        Product p3 = new Product(3250, ", Tomate", ", Sicam", 1.200);

        System.out.println("=== Liste des produits ===");
        p.afficheInfos();
        p1.afficheInfos();
        p2.afficheInfos();
        p3.afficheInfos();

        System.out.println("=== Edite prix product 1 ===");
        p1.setPrix(0.700);
        p1.afficheInfos();

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

        Magasin m1 = new Magasin();

        // Ajouter produits a m1
        m1.ajouterProduit(p1);
        m1.ajouterProduit(p2);
        m1.ajouterProduit(p3);


        Magasin m2 = new Magasin(1, "Tunis");
        // Ajouter produits
        m2.ajouterProduit(p1);
        m2.ajouterProduit(p2);



        // Affichage
        m1.afficheMagasinInfos();

        System.out.println(m2);

        // afficher le total des magasin creés
        System.out.println("\n \n [INFO] Nombre total de magasins : " + Magasin.getTotalMagasin() + " \n \n");

        // afficher le total des produits dans tt les magasins
        System.out.println("\n \n [INFO] Nombre total de produits : " + Magasin.getTotalProduits() + " \n \n");

        System.out.println("=============================\n");



    }
}