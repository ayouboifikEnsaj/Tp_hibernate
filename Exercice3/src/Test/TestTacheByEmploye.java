/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import service.EmployeService;

/**
 *
 * @author PC
 */
public class TestTacheByEmploye {
    public static void main(String[] args) {
        EmployeService es = new EmployeService();
        es.findTacheByEmploye(es.findById(7));
    }
}
