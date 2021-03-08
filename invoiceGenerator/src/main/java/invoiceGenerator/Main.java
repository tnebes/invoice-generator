/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoiceGenerator;

import invoiceGenerator.util.InitialFixtures;
import invoiceGenerator.view.Authorisation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import invoiceGenerator.view.MainMenu;


/**
 *
 * @author tnebes
 */
public class Main {
    
    public Main() {
        new InitialFixtures();
        new Authorisation().setVisible(true);
    }
    
    public static void main(String[] args) {
        new Main();
    }
}


