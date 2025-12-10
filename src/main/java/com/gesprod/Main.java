package com.gesprod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


import com.gesprod.entity.Categorie;
import com.gesprod.entity.Produit;
import com.gesprod.factory.database.EntityManager;
import com.gesprod.factory.database.SgbdName;
import com.gesprod.factory.repository.EntityName;
import com.gesprod.factory.service.ServiceFactory;
import com.gesprod.service.CategorieService;
import com.gesprod.service.ProduitService;


public class Main {
    public static void main(String[] args) {

        // CategorieService categorieService = (CategorieService) ServiceFactory.getInstance(EntityName.Categorie);
        // ProduitService produitService = (ProduitService) ServiceFactory.getInstance(EntityName.Produit);

        // // Vérifier les arguments
        // if (args.length == 0) {
        //     System.out.println("Aucune action spécifiée. Options possibles : ajouter, lister");
        //     return;
        // }

        // String action = args[0].toLowerCase();

        // switch (action) {
        //     case "ajouter":
        //         // Récupérer les infos du produit via variables d'environnement
        //         String libelle = System.getenv("PRODUIT_LIBELLE");
        //         String prixStr = System.getenv("PRODUIT_PRIX");
        //         String categorieIdStr = System.getenv("PRODUIT_CATEGORIE_ID");

        //         if (libelle == null || prixStr == null || categorieIdStr == null) {
        //             System.out.println("Pour ajouter un produit, définissez les variables d'environnement : PRODUIT_LIBELLE, PRODUIT_PRIX, PRODUIT_CATEGORIE_ID");
        //             return;
        //         }

        //         try {
        //             double prix = Double.parseDouble(prixStr);
        //             int categorieId = Integer.parseInt(categorieIdStr);

        //             Produit produit = new Produit();
        //             produit.setLibelle(libelle);
        //             produit.setPrix(prix);
        //             Categorie categorie = new Categorie();
        //             categorie.setId(categorieId);
        //             produit.setCategorie(categorie);

        //             int result = produitService.addProduit(produit);
        //             System.out.println("Produit ajouté avec succès : " + produit.getLibelle());

        //         } catch (NumberFormatException e) {
        //             System.out.println("Erreur : prix ou id de catégorie invalide.");
        //         }
        //         break;

        //     case "lister":
        //         List<Produit> produits = produitService.getAll();
        //         if (produits.isEmpty()) {
        //             System.out.println("Aucun produit trouvé.");
        //         } else {
        //             System.out.println("Liste des produits :");
        //             produits.forEach(p -> {
        //                 System.out.println("ID: " + p.getId() +
        //                                    ", Libellé: " + p.getLibelle() +
        //                                    ", Prix: " + p.getPrix() +
        //                                    ", Catégorie: " + p.getCategorie().getId());
        //             });
        //         }
        //         break;

        //     default:
        //         System.out.println("Action inconnue : " + action);
        //         System.out.println("Options possibles : ajouter, lister");
        // }

        try {
        Map<String, String> db = EntityManager.PersistenceUnit(SgbdName.POSTGRESQL);

        Class.forName(db.get("driver"));
        Connection con = DriverManager.getConnection(
            db.get("url"),
            db.get("user"),
            db.get("password")
        );

        System.out.println("Connexion OK à Neon PostgreSQL !");
        con.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
        
        // CategorieService categorieService = (CategorieService)ServiceFactory.getInstance(EntityName.Categorie);
        // ProduitService produitService = (ProduitService)ServiceFactory.getInstance(EntityName.Produit);
        
        
        // Scanner scanner = new Scanner(System.in);
        // int choice;
        // do {
        //     System.out.println("Menu:");
        //     System.out.println("1. Ajouter un produit");
        //     System.out.println("2. Lister les produits");
        //     System.out.println("3. Quitter");
        //     System.out.print("Choisissez une option: ");
        //     choice = scanner.nextInt();
        //     Produit produit = new Produit();
        //     scanner.nextLine(); // Consommer la nouvelle ligne
        //     switch (choice) {
        //         case 1:
        //             System.out.println("Entrer le libellé du produit:");
        //             produit.setLibelle(scanner.nextLine());
        //             System.out.println("Entrer le prix du produit:");
        //             produit.setPrix(scanner.nextDouble());
        //             System.out.println("Entrer l'id de la catégorie:");
        //             Categorie categorie = new Categorie();
        //             categorie.setId(scanner.nextInt());
        //             produit.setCategorie(categorie);
        //             int result = produitService.addProduit(produit);
        //             break;
        //         case 2:
        //             System.out.println("Liste des produits:");
        //             produitService.getAll().forEach(p -> {
        //                 System.out.println("ID: " + p.getId() + ", Libellé: " + p.getLibelle() + ", Prix: " + p.getPrix() + ", Catégorie: " + p.getCategorie().getId());
        //             });
        //             break;
                    
        //         default:
        //             System.out.println("Choix invalide.");
        //     }
        // } while (choice != 3);
        // scanner.close();
            
        
    }
}