package invoiceGenerator.controller;

import invoiceGenerator.model.Article;
import invoiceGenerator.model.ArticleInvoice;
import invoiceGenerator.util.InvoiceGeneratorException;

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
    protected List<ArticleInvoice> getData(String token) throws InvoiceGeneratorException {
        return null;
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
