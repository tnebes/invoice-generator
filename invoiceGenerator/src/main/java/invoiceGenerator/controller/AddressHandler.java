package invoiceGenerator.controller;

import invoiceGenerator.model.Address;
import invoiceGenerator.util.InvoiceGeneratorException;

import java.util.List;

public class AddressHandler extends Handler<Address> {

    public AddressHandler() {
    }

    public AddressHandler(Address entity) {
        super(entity);
    }

    @Override
    protected List<Address> getData() throws InvoiceGeneratorException {
        return session.createQuery("from address").list();
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
