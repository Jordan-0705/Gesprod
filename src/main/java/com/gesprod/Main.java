package com.gesprod;

import java.util.Scanner;


import com.gesprod.entity.Categorie;
import com.gesprod.entity.Produit;
import com.gesprod.factory.repository.EntityName;
import com.gesprod.factory.service.ServiceFactory;
import com.gesprod.service.CategorieService;
import com.gesprod.service.ProduitService;


public class Main {
    public static void main(String[] args) {


    //     try {
    //     Map<String, String> db = EntityManager.PersistenceUnit(SgbdName.POSTGRESQL);

    //     Class.forName(db.get("driver"));
    //     Connection con = DriverManager.getConnection(
    //         db.get("url"),
    //         db.get("user"),
    //         db.get("password")
    //     );

    //     System.out.println("Connexion OK à Neon PostgreSQL !");
    //     con.close();

    // } catch (Exception e) {
    //     e.printStackTrace();
    // }
        
        CategorieService categorieService = (CategorieService)ServiceFactory.getInstance(EntityName.Categorie);
        ProduitService produitService = (ProduitService)ServiceFactory.getInstance(EntityName.Produit);
        
        
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Ajouter un produit");
            System.out.println("2. Lister les produits");
            System.out.println("3. Quitter");
            System.out.print("Choisissez une option: ");
            choice = scanner.nextInt();
            Produit produit = new Produit();
            scanner.nextLine(); // Consommer la nouvelle ligne
            switch (choice) {
                case 1:
                    System.out.println("Entrer le libellé du produit:");
                    produit.setLibelle(scanner.nextLine());
                    System.out.println("Entrer le prix du produit:");
                    produit.setPrix(scanner.nextDouble());
                    System.out.println("Entrer l'id de la catégorie:");
                    Categorie categorie = new Categorie();
                    categorie.setId(scanner.nextInt());
                    produit.setCategorie(categorie);
                    int result = produitService.addProduit(produit);
                    break;
                case 2:
                    System.out.println("Liste des produits:");
                    produitService.getAll().forEach(p -> {
                        System.out.println("ID: " + p.getId() + ", Libellé: " + p.getLibelle() + ", Prix: " + p.getPrix() + ", Catégorie: " + p.getCategorie().getId());
                    });
                    break;
                    
                default:
                    System.out.println("Choix invalide.");
            }
        } while (choice != 3);
        scanner.close();
            
        
    }
}