/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Commande;
import java.util.Date;
import service.CommandeService;

/**
 *
 * @author PC
 */
public class TestCommande {
    public static void main(String[] args) {
       CommandeService cs = new CommandeService();
       cs.create(new Commande(new Date()));
        cs.create(new Commande(new Date()));
         cs.create(new Commande(new Date("2023/10/01")));
          cs.create(new Commande(new Date("2023/10/08")));
    }
    
    
    
    
}
