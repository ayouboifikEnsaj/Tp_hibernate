/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.util.Date;
import java.util.List;
import ma.projet.entity.Produit;
import ma.projet.service.ProduitService;

/**
 *
 * @author HP
 */
public class Test {
    
    public static void main(String[] args) {
     
        ProduitService ps = new ProduitService();
        int year = 2023 - 1900;
        
        // creation des produit
        Produit produit_1 = new Produit("sac", "r1", new Date(year, 3, 12), 200, "dest1");
        Produit produit_2 = new Produit("machetee", "r2", new Date(year, 2, 14), 50, "dest2");
        Produit produit_3 = new Produit("sacadods", "r3", new Date(year, 9, 22), 1300, "dest3");
        Produit produit_4 = new Produit("bauty", "r4", new Date(year, 7, 1), 150, "dest4");
        Produit produit_5 = new Produit("media", "r5", new Date(year, 5, 5), 300, "dest5");
        
        ps.create(produit_1);
        ps.create(produit_2);
        ps.create(produit_3);
        ps.create(produit_4);
        ps.create(produit_5);
        
        // afficher tous les produits
        int s = 1;
        for(Produit p : ps.findAll(null)){
            System.out.println("Produit " + String.valueOf(s) + ": " + p.getMarque());
        }
        
        
        // afficher les infos sur le produit 2
        
        Produit p2 = ps.findById(2);
        System.out.println("Margue: " + p2.getMarque());
        System.out.println("Referenc: " + p2.getReference());
        System.out.println("DateAchat: " + p2.getDateAchat());
        System.out.println("Prix: " + p2.getPrix());
        System.out.println("Designation: " + p2.getDesignation());
        
        // supprimer le produit 3
        ps.delete(ps.findById(3));
        
        // modifier les info du produit 1
        Produit p1 = ps.findById(1);
        p1.setDesignation("updated Destin 1");
        ps.update(p1);
        
        // affichier la list des produits dont le prix > 100
        System.out.println("\nles produits dont le prix > 100: \n");
        for(Produit p : ps.findAll(null)){
            if(p.getPrix() > 100){
                System.out.println(p.getMarque());
            }
        }
        
        // Afficher la liste des produits Commander entre deux dates lus au clavier.
        
        System.out.println("\nLa liste des produits commander entre 01/03/2023 et 01/08/2023\n");
        Date minDate = new Date(year, 4, 1);
        Date maxDate = new Date(year, 9, 1);
        
        for(Produit p : ps.findAll(null)){
            if( (maxDate.compareTo(p.getDateAchat()) == 1 || maxDate.compareTo(p.getDateAchat()) == 0)&& 
                    (minDate.compareTo(p.getDateAchat()) == -1 || minDate.compareTo(p.getDateAchat()) == 0)
        )
            {
                System.out.println(p.getMarque() + ", " + p.getDateAchat());
            }
        }
   
    }
}
