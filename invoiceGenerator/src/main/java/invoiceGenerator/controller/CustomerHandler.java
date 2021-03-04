package invoiceGenerator.controller;

import invoiceGenerator.model.Customer;
import invoiceGenerator.util.InvoiceGeneratorException;

import java.util.List;

public class CustomerHandler extends Handler<Customer> {

    public CustomerHandler() {
    }

    public CustomerHandler(Customer entity) {
        super(entity);
    }

    @Override
    protected List<Customer> getData() throws InvoiceGeneratorException {
        return session.createQuery("from customer").list();
    }

    @Override
    protected void createValidation() throws InvoiceGeneratorException {
        informationCheck();
    }

    @Override
    protected void updateValidation() throws InvoiceGeneratorException {
        informationCheck();
    }

    @Override
    protected void deleteValidation() throws InvoiceGeneratorException {

    }

    private void informationCheck() throws InvoiceGeneratorException {
        if (entity.isType() == Customer.LEGAL_PERSON) {
            if (entity.getVATID() == null || entity.getVATID().isBlank()) {
                throw new InvoiceGeneratorException("VATID must be given for legal persons.");
            }
            if (entity.getName() == null || entity.getName().isBlank()) {
                throw new InvoiceGeneratorException("A legal person must have a name.");
            }
            if (entity.getBillingAddress() == null) {
                throw new InvoiceGeneratorException("A legal person must have a billing address.");
            }
        } else {
            if (entity.getFirstName() == null || entity.getFirstName().isBlank()) {
                throw new InvoiceGeneratorException("A natural person must have a first name.");
            }
            if (entity.getLastName() == null || entity.getLastName().isBlank()) {
                throw new InvoiceGeneratorException("A natural person must have a last name.");
            }
            if (entity.getBillingAddress() == null) {
                throw new InvoiceGeneratorException("A natural person must have a valid billing address.");
            }
        }
    }

}
