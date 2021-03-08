/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoiceGenerator.controller;

import invoiceGenerator.model.Operator;
import invoiceGenerator.util.InvoiceGeneratorException;
import java.util.List;

/**
 *
 * @author tnebes
 */
public class OperatorHandler extends Handler<Operator> {

    /**
     * Authorises the operator
     * @param email of the operator
     * @param password plain char[] entered by user.
     * @return instance of Operator class if it is in the database. Returns null if the operator does not exist or the password does not match.
     */
    public Operator authorise(String email, char[] password) {
        
        Operator operator = (Operator) session
                .createQuery("from operator o where o.email = :email")
                .setParameter("email", email)
                .getSingleResult();
        if (operator == null) {
            return null;
        }
        //return BCrypt.checkpw(new String(password), operator.getPassword()) ? operator : null;
        //temp
        return null;
    }
    
    
    
    @Override
    protected List<Operator> getData() throws InvoiceGeneratorException {
        return session.createQuery("from operator").list();
    }

    @Override
    protected void createValidation() throws InvoiceGeneratorException {
        
    }

    @Override
    protected void updateValidation() throws InvoiceGeneratorException {
        
    }
        
    @Override
    protected void deleteValidation() throws InvoiceGeneratorException {
        
    }
    
    
        
}
