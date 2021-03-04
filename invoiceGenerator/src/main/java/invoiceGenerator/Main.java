/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoiceGenerator;

import invoiceGenerator.util.InitialFixtures;
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
        MainMenu mainMenu = new MainMenu();
        mainMenu.setVisible(true);
    }
    
    public static void main(String[] args) {
        new Main();
    }
}


