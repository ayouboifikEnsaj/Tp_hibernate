/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.logging.Logger;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author PC
 */
@Entity

public class LigneCommandeProduit {
    @EmbeddedId
    private LigneCommandeProduitPk pk;  //cle primaire
    
    private int quantite;
    
   @ManyToOne
   @JoinColumn(name = "commande" , insertable = false , updatable = false)
   private Commande commande;
   @ManyToOne
   @JoinColumn(name = "produit", insertable = false , updatable = false)
   private Produit produit;

    public LigneCommandeProduit() {
    }
        public LigneCommandeProduit(LigneCommandeProduitPk pk, int quantite) {
        this.pk = pk;
        this.quantite = quantite;
    }

    public LigneCommandeProduit(int quantite, Commande commande, Produit produit) {
        this.quantite = quantite;
        this.commande = commande;
        this.produit = produit;
    }

    public LigneCommandeProduitPk getPk() {
        return pk;
    }

    public int getQuantite() {
        return quantite;
    }

    public Commande getCommande() {
        return commande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setPk(LigneCommandeProduitPk pk) {
        this.pk = pk;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
    
   
    
    
    
    
    
    
    
}
