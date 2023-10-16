/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "Produit")
@NamedQuery(name = "findBetweenDate" , query = "from Produit where dateAchat between :d1 and :d2")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "marque")
    private String marque;
    @Column(name = "reference")
    private String reference;
    @Temporal(TemporalType.DATE)
    @Column(name = "Date")
    private Date dateAchat;
    @Column(name = "prix")
    private double prix;
    @Column(name = "destination")
    private String designation;
    @ManyToOne
    private Categorie categorie;

    public Produit() {
    }



    public Produit(String marque, String reference, Date dateAchat, double prix, String designation, Categorie categorie) {
        this.marque = marque;
        this.reference = reference;
        this.dateAchat = dateAchat;
        this.prix = prix;
        this.designation = designation;
        this.categorie = categorie;
    }
    

    public int getId() {
        return id;
    }

    public String getMarque() {
        return marque;
    }

    public String getReference() {
        return reference;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public double getPrix() {
        return prix;
    }

    public String getDesignation() {
        return designation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", marque=" + marque + ", reference=" + reference + ", dateAchat=" + dateAchat + ", prix=" + prix + ", designation=" + designation + '}';
    }


      
      
    
            
   
}
