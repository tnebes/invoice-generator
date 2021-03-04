package invoiceGenerator.controller;

import invoiceGenerator.model.TransactionType;
import invoiceGenerator.util.InvoiceGeneratorException;

import java.util.List;

public class TransactionTypeHandler extends Handler<TransactionType> {


    @Override
    protected List<TransactionType> getData() throws InvoiceGeneratorException {
        return session.createQuery("from transaction_type").list();
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
