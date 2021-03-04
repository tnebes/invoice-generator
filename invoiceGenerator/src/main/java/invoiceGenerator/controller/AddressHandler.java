package invoiceGenerator.controller;

import invoiceGenerator.model.Address;
import invoiceGenerator.util.InvoiceGeneratorException;

import java.util.List;

public class AddressHandler extends Handler<Address> {


    @Override
    protected List<Address> getData() throws InvoiceGeneratorException {
        List<Address> addresses = session.createQuery("from address").list();
        session.getTransaction().commit();
        return addresses;
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
