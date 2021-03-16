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

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.*;

/**
 *
 * @author tnebes
 */
public class AuthorisationUtil {
    
    public static boolean login(Authorisation authorisation, JTextField usernameTextField, JPasswordField passwordTextField) {
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
        Operator operator =
                new OperatorHandler().getOperator(usernameTextField.getText(), passwordTextField.getPassword());

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
