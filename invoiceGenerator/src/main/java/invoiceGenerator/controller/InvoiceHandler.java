package invoiceGenerator.controller;

import invoiceGenerator.model.ArticleInvoice;
import invoiceGenerator.model.Invoice;
import invoiceGenerator.util.InvoiceGeneratorException;

import java.util.List;

public class InvoiceHandler extends Handler<Invoice> {


    @Override
    public List<Invoice> getData() throws InvoiceGeneratorException {
        return session.createQuery("from invoice").list();
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
    
    
    
    /*
     * article_invoice goes here
    // TODO
     * before saving invoice save each article_invoice
     * @override create
    */

    // TODO add the getter for article_invoice
    // inverse relationship?
    /*
    @Override
    public Invoice create() throws InvoiceGeneratorException {
        // for (ArticleInvoice articleInvoice :  ) 
    }
    */
}
