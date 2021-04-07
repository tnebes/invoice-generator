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
    public List<Address> getData(String token) throws InvoiceGeneratorException {
        List<Address> addresses0 = session.createQuery("from address where lower(country) like lower(:searchToken) " +
                "or lower(zip_code) like lower(:searchToken) " +
                "or lower(street) like lower(:searchToken) " +
                "or lower(street_letter) like lower(:searchToken) " +
                "or lower(street_number) like lower(:searchToken)").setParameter("searchToken", "%" + token + "%").list();
        List<Address> addresses1 = session.createQuery("from address where id = :searchToken").setParameter("searchToken", Long.parseLong(token)).list();
        if (addresses1.size() == 0) {
            return addresses0;
        }
        addresses0.addAll(addresses1);
        return addresses0;
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
