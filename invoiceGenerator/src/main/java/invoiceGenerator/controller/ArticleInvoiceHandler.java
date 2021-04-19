package invoiceGenerator.controller;

import invoiceGenerator.model.Article;
import invoiceGenerator.model.ArticleInvoice;
import invoiceGenerator.model.Invoice;
import invoiceGenerator.util.InvoiceGeneratorException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ArticleInvoiceHandler extends Handler<ArticleInvoice> {

    public ArticleInvoiceHandler(ArticleInvoice entity) {
        super(entity);
    }

    public ArticleInvoiceHandler() {

    }

    @Override
    protected List<ArticleInvoice> getData() throws InvoiceGeneratorException {
        return session.createQuery("from article_invoice").list();
    }

    @Override
    public List<ArticleInvoice> getData(String token) throws InvoiceGeneratorException {
        return null;
    }

    @Override
    protected void createValidation() throws InvoiceGeneratorException {
        checkPrice();
    }

    private void checkPrice() throws InvoiceGeneratorException {
        if (entity.getDiscount().compareTo(BigDecimal.ZERO) < 0) {
            throw new InvoiceGeneratorException("Discount cannot be negative.");
        }
        if (entity.getDiscount().compareTo(BigDecimal.valueOf(100L)) > 0) {
            throw new InvoiceGeneratorException("Discount cannot be above 100%.");
        }
    }

    @Override
    protected void updateValidation() throws InvoiceGeneratorException {
        checkPrice();
    }

    @Override
    protected void deleteValidation() throws InvoiceGeneratorException {

    }
}
