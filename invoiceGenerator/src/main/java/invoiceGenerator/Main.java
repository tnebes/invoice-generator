/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoiceGenerator;

import invoiceGenerator.view.SplashScreen;


/**
 *
 * @author tnebes
 */
public class Main {
    
    public Main() {
        new SplashScreen().setVisible(true);
    }
    
    public static void main(String[] args) {
        new Main();
    }
}


