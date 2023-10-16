/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.util.Date;
import service.TacheService;

/**
 *
 * @author PC
 */
public class TestGetTachesRealiseesEntreDeuxDate {
    public static void main(String[] args) {
        TacheService ts = new TacheService();
        ts.getTachesRealiseesEntreDeuxDate(new Date(2021, 0, 1), new Date(2023, 11, 31));
    }
}
