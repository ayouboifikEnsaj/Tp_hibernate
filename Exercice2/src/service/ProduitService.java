/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.IDao;
import entities.Categorie;
import entities.Commande;
import entities.LigneCommandeProduit;
import entities.Produit;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author PC
 */
public class ProduitService implements IDao<Produit> {

    @Override
    public boolean create(Produit o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return false;
    }

    @Override
    public boolean delete(Produit o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return false;
    }

    @Override
    public boolean update(Produit o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return false;
    }

    @Override
    public Produit findById(int id) {
        Produit produit = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            produit = (Produit) session.get(Produit.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return produit;
    }

    @Override
    public List<Produit> findAll() {
        List<Produit> produits = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            produits = session.createQuery("from Produit").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return produits;
    }

    public void  findByCategorie(Categorie c) {
       CategorieService cs =  new CategorieService();
       List<Produit> produits ;
       produits = cs.findById(c.getId()).getProduits();
       for(Produit e : produits){
           System.out.println(e+"\n");
       }
       
    }
    public List<Produit> findBetweenDate(Date d1, Date d2){
         List<Produit> produits = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Query qeury = session.getNamedQuery("findBetweenDate");
            qeury.setParameter("d1", d1);
             qeury.setParameter("d2", d2);
            produits = qeury.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return produits;
    }
    public void findProduitByCommande(Commande c){
        
       List<LigneCommandeProduit> commandeProduits = null;
       Session session = null;
       Transaction tx = null;
        SimpleDateFormat format = new SimpleDateFormat();
               
       String query =  "select l FROM LigneCommandeProduit l "
                + "join l.produit Produit "
                + "join l.commande Commande "
                + "where Commande.id = :id";
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
             commandeProduits =  session.createQuery(query)
                    .setParameter("id", c.getId()).list();
             tx.commit();
             
             System.out.println("Commande    : "+c.getId()+"\t\t  Date  : "+format.format(c.getDate())+"\n");
               System.out.println("\tRéférence\t\tPrix\t\tQuantité");
               for(LigneCommandeProduit l : commandeProduits){
                   System.out.println("\t"+ l.getProduit().getReference() +"\t\t"+ l.getProduit().getPrix()+"\t\t"+ l.getQuantite());
        }
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
            
        }finally{
            if (session != null) 
                session.close();
        }
       
    }
    public void listProduitPrix(Double prix){
        
    }
}
