package invoiceGenerator.util;

import invoiceGenerator.model.Invoice;

public class InvoicePrinter {

    private Invoice invoice = null;

    public InvoicePrinter(Invoice invoice) {

    }

    public interface ReturnInvoice {
        void run(Invoice invoice);
    }

    public void invoice(ReturnInvoice returnInvoice) {
        returnInvoice.run(pullInvoice());
    }

    public Invoice pullInvoice() {
        return invoice;
    }

}
