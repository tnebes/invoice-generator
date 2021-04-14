package invoiceGenerator.controller;

import invoiceGenerator.model.Status;
import invoiceGenerator.util.InvoiceGeneratorException;

import java.util.List;

public class StatusHandler extends Handler<Status> {


    @Override
    public List<Status> getData() throws InvoiceGeneratorException {
        return session.createQuery("from status").list();
    }

    @Override
    public List<Status> getData(String token) throws InvoiceGeneratorException {
        return null;
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
