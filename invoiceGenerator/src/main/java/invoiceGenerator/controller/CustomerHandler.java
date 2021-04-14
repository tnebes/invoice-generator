package invoiceGenerator.controller;

import invoiceGenerator.model.Address;
import invoiceGenerator.model.Customer;
import invoiceGenerator.util.InvoiceGeneratorException;
import org.hibernate.query.Query;

import java.util.List;

public class CustomerHandler extends Handler<Customer> {

    public CustomerHandler() {
    }

    public CustomerHandler(Customer entity) {
        super(entity);
    }

    @Override
    public List<Customer> getData() throws InvoiceGeneratorException {
        return session.createQuery("from customer").list();
    }

    @Override
    public List<Customer> getData(String token) throws InvoiceGeneratorException {
        List<Customer> customers0 = session.createQuery("from customer where lower(vatid) like lower(:searchToken) " +
                "or lower(first_name) like lower(:searchToken) " +
                "or lower(last_name) like lower(:searchToken) " +
                "or lower(middle_name) like lower(:searchToken) " +
                "or lower(name) like lower(:searchToken)" +
                "or lower(national_id_number) like lower(:searchToken)").setParameter("searchToken", "%" + token + "%").list();
        // TODO this is badness.
        Long tokenID;
        try {
            tokenID = Long.parseLong(token);
        } catch (NumberFormatException e) {
            return customers0;
        }
        List<Customer> customers1 = session.createQuery("from customer where id = :searchToken").setParameter("searchToken", tokenID).list();
        if (customers1.size() == 0) {
            return customers0;
        }
        customers0.addAll(customers1);
        return customers0;
    }

    public List<Customer> getCustomersWithAddress(Address address) throws InvoiceGeneratorException {
        Query query = session.createQuery("from customer where billingAddress_id = :i or shippingAddress_id = :i");
        query.setParameter("i", address.getId());
        return query.list();
    }

    public Address getBillingAddressOfCustomer() throws InvoiceGeneratorException {
        Query query = session.createQuery("from address where id = :i");
        query.setParameter("i", entity.getBillingAddress().getId());
        return (Address) query.getSingleResult();
    }

    public Address getShippingAddressOfCustomer() throws InvoiceGeneratorException {
        Query query = session.createQuery("from address where id = :i");
        query.setParameter("i", entity.getShippingAddress().getId());
        return (Address) query.getSingleResult();
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
        checkHasConnection();
    }

    private void checkHasConnection() {
        // TODO check if customer has invoice.
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
            if (this.getData().size() != 0) {
                for (Customer legalCustomer : this.getData()) {
                    if (entity.getVATID().equals(legalCustomer.getVATID()) && !(entity.equals(legalCustomer))) {
                        String message = "Customer cannot have the VATID " + entity.getVATID() +
                                " as used by customer " +
                                legalCustomer.getId();
                        throw new InvoiceGeneratorException(message);
                    }
                }
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
            if (entity.getNationalIdNumber() != null
                    && !entity.getNationalIdNumber().isBlank()
                    && this.getData().size() != 0) {
                for (Customer naturalCustomer : this.getData()) {
                    if (entity.getNationalIdNumber().equals(naturalCustomer.getNationalIdNumber()) && !(entity.equals(naturalCustomer))) {
                        String message = "Customer cannot have the national ID number " + entity.getNationalIdNumber() +
                                " as used by customer " + naturalCustomer.getNationalIdNumber();
                        throw new InvoiceGeneratorException(message);
                    }
                }
            }
        }
    }

}
