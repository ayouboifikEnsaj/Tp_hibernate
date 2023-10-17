/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.LigneCommandeProduit;
import entities.Produit;
import java.util.Date;
import java.util.List;
import service.ProduitService;

/**
 *
 * @author PC
 */
public class TestHql {
    public static void main(String[] args) {
        ProduitService ps = new ProduitService();
        List<Produit> produits = null;
        produits =  ps.findBetweenDate(new Date("2023/10/14"), new Date("2023/10/16"));
        System.out.println("\n-------------------les produit entre deux date 2023/10/14 et 2023/10/16-----------------------------------------\n");
        for(Produit p : produits){
            System.out.println(p+"\n");
        }
    }
    
}
