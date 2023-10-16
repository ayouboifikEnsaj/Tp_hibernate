/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Commande;
import entities.LigneCommandeProduit;
import entities.LigneCommandeProduitPk;
import entities.Produit;
import service.CommandeService;
import service.LigneCommandeProduitService;
import service.ProduitService;

/**
 *
 * @author PC
 */
public class TestLigneCommaandeProduit {
    public static void main(String[] args) {
        CommandeService cs = new CommandeService();
        ProduitService ps = new ProduitService();
        LigneCommandeProduitService lcps = new LigneCommandeProduitService();
         Commande c = cs.findById(1);
         Produit p1 = ps.findById(1);
         Produit p2 = ps.findById(2);
         lcps.create(new LigneCommandeProduit(new LigneCommandeProduitPk(p1.getId(), c.getId()),10));
         lcps.create(new LigneCommandeProduit(new LigneCommandeProduitPk(p2.getId(), c.getId()), 2000));
         
    }
    
}
