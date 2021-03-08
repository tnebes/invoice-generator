package invoiceGenerator.controller;

import invoiceGenerator.model.Invoice;
import invoiceGenerator.util.InvoiceGeneratorException;

import java.util.List;

public class InvoiceHandler extends Handler<Invoice> {


    @Override
    protected List<Invoice> getData() throws InvoiceGeneratorException {
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
}
