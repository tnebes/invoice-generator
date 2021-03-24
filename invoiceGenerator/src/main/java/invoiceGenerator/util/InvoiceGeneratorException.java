package invoiceGenerator.util;

import javax.swing.*;

public class InvoiceGeneratorException extends Exception {

    public InvoiceGeneratorException() {

    }

    public InvoiceGeneratorException(String message) {
        super(message);
        JOptionPane.showMessageDialog(null, message);
    }

}
