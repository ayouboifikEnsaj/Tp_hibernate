/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import entities.Employe;
import service.EmployeService;

/**
 *
 * @author PC
 */
public class TestEmploye {
    public static void main(String[] args) {
        EmployeService es = new EmployeService();
        es.create(new Employe("Ayoub", "oifik", "0703812515"));
         es.create(new Employe("Amine", "oifik", "0703812515"));
          es.create(new Employe("youness", "oifik", "0703812515"));
           es.create(new Employe("Mohmmed reda", "oifik", "0703812515"));
           
    }
    
}
