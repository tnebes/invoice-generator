/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoiceGenerator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import invoiceGenerator.UI.MainMenu;


/**
 *
 * @author tnebes
 */
public class Main {
    
    public Main() {
        
        SessionFactory sessionFactory = invoiceGenerator.util.HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.getTransaction().commit();
        
        MainMenu mainMenu = new MainMenu();
        mainMenu.setVisible(true);
    }
    
    public static void main(String[] args) {
        new Main();
    }
}


