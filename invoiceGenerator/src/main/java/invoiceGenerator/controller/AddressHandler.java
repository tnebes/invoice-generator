package invoiceGenerator.controller;

import invoiceGenerator.model.Address;
import invoiceGenerator.model.Customer;
import invoiceGenerator.util.InvoiceGeneratorException;

import java.util.List;

public class AddressHandler extends Handler<Address> {

    public AddressHandler() {
    }

    public AddressHandler(Address entity) {
        super(entity);
    }

    @Override
    public List<Address> getData() throws InvoiceGeneratorException {
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
        checkAddressAssociatedWithCustomer();
    }

    private void checkAddressAssociatedWithCustomer() throws InvoiceGeneratorException {
        if (entity.getAssociatedBillingCustomers().size() != 0
        || entity.getAssociatedShippingCustomers().size() != 0) {
            StringBuilder sb = new StringBuilder("Address cannot be deleted as it is associated with customer(s): ");
            for (Customer customer : entity.getAssociatedBillingCustomers()) {
                sb.append(customer.toString()).append("\n");
            }
            for (Customer customer : entity.getAssociatedShippingCustomers()) {
                sb.append(customer.toString()).append("\n");
            }
            throw new InvoiceGeneratorException(sb.toString());
        }
    }
}
