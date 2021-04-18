package invoiceGenerator.controller;

import invoiceGenerator.model.Invoice;
import invoiceGenerator.model.Status;
import invoiceGenerator.model.TransactionType;
import invoiceGenerator.util.InvoiceGeneratorException;

import java.util.List;

public class InvoiceHandler extends Handler<Invoice> {


    @Override
    public List<Invoice> getData() throws InvoiceGeneratorException {
        return session.createQuery("from invoice").list();
    }

    @Override
    public List<Invoice> getData(String token) throws InvoiceGeneratorException {
        //TODO add token
        return getData();
    }

    public List<Invoice> getData(Status status) throws InvoiceGeneratorException {
        List<Invoice> invoices = getData();
        invoices.removeIf(invoice -> !invoice.getStatus().equals(status));
        return invoices;
    }

    public List<Invoice> getData(TransactionType transactionType) throws InvoiceGeneratorException {
        List<Invoice> invoices = getData();
        invoices.removeIf(invoice -> !invoice.getTransactionType().equals(transactionType));
        return invoices;
    }

    public List<Invoice> getData(Status status, TransactionType transactionType) throws InvoiceGeneratorException {
        List<Invoice> invoices = getData();
        invoices.removeIf(invoice -> !invoice.getStatus().equals(status));
        invoices.removeIf(invoice -> !invoice.getTransactionType().equals(transactionType));
        return invoices;
    }

    public List<Invoice> getData(Status status, TransactionType transactionType, String token) throws InvoiceGeneratorException {
        // TODO add token
        List<Invoice> invoices = getData();
        invoices.removeIf(invoice -> !invoice.getStatus().equals(status));
        invoices.removeIf(invoice -> !invoice.getTransactionType().equals(transactionType));
        return invoices;
    }

    public List<Invoice> getData(TransactionType transactionType, String token) throws InvoiceGeneratorException {
        // TODO add token
        List<Invoice> invoices = getData();
        invoices.removeIf(invoice -> !invoice.getTransactionType().equals(transactionType));
        return invoices;
    }

    public List<Invoice> getData(Status status, String token) throws InvoiceGeneratorException {
        // TODO add token
        List<Invoice> invoices = getData();
        invoices.removeIf(invoice -> !invoice.getStatus().equals(status));
        return invoices;
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
