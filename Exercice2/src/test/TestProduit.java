/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Categorie;
import service.ProduitService;
import entities.Produit;
import java.util.Date;
import service.CategorieService;
import sun.security.krb5.internal.APReq;

/**
 *
 * @author PC
 */
public class TestProduit {

    public static void main(String[] args) {
        ProduitService ps = new ProduitService();
        CategorieService cs = new CategorieService();
        ps.create(new Produit("s", "r", new Date(), 100, "d", cs.findById(1)));
        ps.create(new Produit("s", "r", new Date(), 100, "d", cs.findById(1)));
        ps.create(new Produit("s", "r", new Date(), 100, "d", cs.findById(1)));
        ps.create(new Produit("b", "r", new Date(), 200, "m", cs.findById(2)));
        ps.create(new Produit("b", "r", new Date(), 200, "m", cs.findById(2)));
        ps.create(new Produit("b", "r", new Date(), 200, "m", cs.findById(2)));
     
        ps.create(new Produit("s", "r", new Date("2024/10/12"), 100, "d", cs.findById(1)));

    }
}
