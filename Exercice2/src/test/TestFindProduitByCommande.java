/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import service.CommandeService;
import service.ProduitService;

/**
 *
 * @author PC
 */
public class TestFindProduitByCommande {
    public static void main(String[] args) {
        ProduitService  ps = new ProduitService();
        CommandeService cs = new CommandeService();
        ps.findProduitByCommande(cs.findById(1));
    }
}
