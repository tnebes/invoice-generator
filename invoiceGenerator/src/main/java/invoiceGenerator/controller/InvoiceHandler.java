package invoiceGenerator.controller;

import invoiceGenerator.model.Customer;
import invoiceGenerator.model.Invoice;
import invoiceGenerator.model.Status;
import invoiceGenerator.model.TransactionType;
import invoiceGenerator.util.InvoiceGeneratorException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class InvoiceHandler extends Handler<Invoice> {


    @Override
    public List<Invoice> getData() throws InvoiceGeneratorException {
        return session.createQuery("from invoice").list();
    }

    @Override
    public List<Invoice> getData(String token) throws InvoiceGeneratorException {
        token = token.toLowerCase();
        List<Invoice> invoices = getData();
        List<Invoice> returnInvoices = new ArrayList<>();
        returnInvoices.addAll(invoices);
        // absolutely cursed.
        for (Invoice invoice : invoices) {
            if (invoice.getId().toString().contains(token)) {
                continue;
            }
            if (invoice.getCustomer() != null) {
                if (invoice.getCustomer().isType() == Customer.NATURAL_PERSON) {
                    if (invoice.getCustomer().getFirstName().toLowerCase().contains(token)) {
                        continue;
                    }
                    if (invoice.getCustomer().getLastName().toLowerCase().contains(token)) {
                        continue;
                    }
                    if (invoice.getCustomer().getMiddleName().toLowerCase().contains(token)) {
                        continue;
                    }
                    if (invoice.getCustomer().getNationalIdNumber().contains(token)) {
                        continue;
                    }
                } else {
                    if (invoice.getCustomer().getName().toLowerCase().contains(token)) {
                        continue;
                    }
                    if (invoice.getCustomer().getVATID().toLowerCase().contains(token)) {
                        continue;
                    }
                }
                if (invoice.getId().toString().contains(token)) {
                    continue;
                }
                if (invoice.getAmountDue().toString().contains(token)) {
                    continue;
                }
                if (invoice.getAmountPaid().toString().contains(token)) {
                    continue;
                }
            }
            returnInvoices.remove(invoice);
        }
        return returnInvoices;
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
        List<Invoice> invoices = getData(token);
        invoices.removeIf(invoice -> !invoice.getStatus().equals(status));
        invoices.removeIf(invoice -> !invoice.getTransactionType().equals(transactionType));
        return invoices;
    }

    public List<Invoice> getData(TransactionType transactionType, String token) throws InvoiceGeneratorException {
        List<Invoice> invoices = getData(token);
        invoices.removeIf(invoice -> !invoice.getTransactionType().equals(transactionType));
        return invoices;
    }

    public List<Invoice> getData(Status status, String token) throws InvoiceGeneratorException {
        List<Invoice> invoices = getData(token);
        invoices.removeIf(invoice -> !invoice.getStatus().equals(status));
        return invoices;
    }

    @Override
    protected void createValidation() throws InvoiceGeneratorException {
        checkAmounts();
    }

    @Override
    protected void updateValidation() throws InvoiceGeneratorException {
        checkAmounts();
    }

    private void checkAmounts() throws InvoiceGeneratorException {

    }

    @Override
    protected void deleteValidation() throws InvoiceGeneratorException {

    }

}
