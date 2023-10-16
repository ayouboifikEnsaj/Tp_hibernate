/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.IDao;
import entities.Employe;
import entities.EmployeTache;
import entities.Projet;
import java.text.SimpleDateFormat;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author PC
 */
public class EmployeService implements IDao<Employe> {

    @Override
    public boolean create(Employe o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return false;
    }

    @Override
    public boolean delete(Employe o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return false;
    }

    @Override
    public boolean update(Employe o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return false;
    }

    @Override
    public Employe findById(int id) {
        Employe employe = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            employe = (Employe) session.get(Employe.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
               session.close();
        }
        return employe;
    }

    @Override
    public List<Employe> findAll() {
        List<Employe> employes = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            employes = session.createQuery("from Employe").list();
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return employes;
    }
    
    public void projetByEmploye(Employe e){
        
        EmployeService es = new EmployeService();
        List<Projet> projets;
        projets = es.findById(e.getId()).getProjets();
        for(Projet p : projets){
            System.out.println(p);
        }
        
    }
     public void findTacheByEmploye(Employe  e){
        
       List<EmployeTache> employeTaches = null;
       Session session = null;
       Transaction tx = null;
       
               
       String query =  "select l FROM employetache l "
                + "join l.emplpoye employe "
                + "join l.tache tache "
                + "where employe.id = :id";
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
             employeTaches =  session.createQuery(query)
                    .setParameter("id", e.getId()).list();
             tx.commit();
             
             
               for(EmployeTache l : employeTaches ){
                   System.out.println(l.getTache());
        }
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
            
        }finally{
            if (session != null) 
                session.close();
        }
       
    }

}
