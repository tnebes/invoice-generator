/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoiceGenerator.util;

import invoiceGenerator.controller.OperatorHandler;
import invoiceGenerator.model.Operator;
import invoiceGenerator.view.Application;
import invoiceGenerator.view.Authorisation;
import invoiceGenerator.view.MainMenu;
import org.mindrot.jbcrypt.BCrypt;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.persistence.NoResultException;
import javax.swing.*;

/**
 *
 * @author tnebes
 */
public class AuthorisationUtil {

    public static void createDefaultOperator() {
        Operator operator = new Operator();
        operator.setEmail("tnebes@drau.de");
        operator.setPassword(BCrypt.hashpw("edunova", BCrypt.gensalt()));
        operator.setFirstName("Tomislav");
        operator.setLastName("Nebes");
        OperatorHandler operatorHandler = new OperatorHandler();
        try {
            operatorHandler.setEntity(operator);
            operatorHandler.create();
        } catch (InvoiceGeneratorException e) {
            e.printStackTrace();
        }
    }
    
    public static boolean login(Authorisation authorisation, JTextField usernameTextField, JPasswordField passwordTextField) {
        OperatorHandler operatorHandler = new OperatorHandler();
        try {
            if (operatorHandler.getData().size() == 0) {
                createDefaultOperator();
            }
        } catch (InvoiceGeneratorException e) {
            e.printStackTrace();
        }

        if(usernameTextField.getText().isEmpty()) {
            authorisation.handleError(usernameTextField, "email is required.");
            return false;
        }

        try {
            InternetAddress email = new InternetAddress(usernameTextField.getText());
            email.validate();
        } catch (AddressException e) {
            authorisation.handleError(usernameTextField, "email is not valid.");
        }

        if (passwordTextField.getPassword().length == 0) {
            authorisation.handleError(usernameTextField, "password is required.");
            return false;
        }
        Operator operator = null;
        try {
            operator =
                    new OperatorHandler().getOperator(usernameTextField.getText(), passwordTextField.getPassword());
        } catch (NoResultException e) {
            JOptionPane.showMessageDialog(null,"No such user found.");
            return false;
        }

        if (operator == null) {
            authorisation.handleError(usernameTextField, "username or password is invalid.");
        } else {
            Application.operator = operator;
            operator.setPassword(null);
        }
        return operator != null;
    }

    public static void createMainMenu() {
        new MainMenu().setVisible(true);
    }
}
