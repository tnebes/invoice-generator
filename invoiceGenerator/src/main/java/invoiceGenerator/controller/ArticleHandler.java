package invoiceGenerator.controller;

import invoiceGenerator.model.Article;
import invoiceGenerator.util.Constants;
import invoiceGenerator.util.InvoiceGeneratorException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

public class ArticleHandler extends Handler<Article> {


    @Override
    protected List<Article> getData() throws InvoiceGeneratorException {
        session.beginTransaction();
        List<Article> articles = session.createQuery("from article").list();
        session.getTransaction().commit();
        return articles;
    }

    @Override
    protected void createValidation() throws InvoiceGeneratorException {
        priceCheck();
        warehouseCheck();
    }

    @Override
    protected void updateValidation() throws InvoiceGeneratorException {
        priceCheck();
    }

    @Override
    protected void deleteValidation() throws InvoiceGeneratorException {

    }

    private void priceCheck() throws InvoiceGeneratorException {
        if (entity.getWholesalePrice().compareTo(BigDecimal.ZERO) < 0) {
            throw new InvoiceGeneratorException("Wholesale price cannot be negative.");
        }
        if (entity.getRetailPrice().compareTo(BigDecimal.ZERO) < 0) {
            throw new InvoiceGeneratorException("Retail price cannot be negative.");
        }
        if (entity.getTaxRate() < 0) {
            throw new InvoiceGeneratorException("Tax rate cannot be negative.");
        }
        if (entity.getRetailPrice().subtract(entity.getWholesalePrice().multiply(BigDecimal.valueOf(entity.getTaxRate()))).abs().compareTo(BigDecimal.valueOf(Constants.epsilon)) > 0) {
            throw new InvoiceGeneratorException("Price difference between retail and wholesale * tax rate detected.");
        }
    }

    private void warehouseCheck() throws InvoiceGeneratorException {
        if (entity.getWarehouseQuantity() < 0) {
            throw new InvoiceGeneratorException("Quantity cannot be negative.");
        }
        List<Article> articles = getData();
        // NOTE this is extremely inefficient.
        for (Article article : articles) {
            if (entity.getWarehouseLocation().toLowerCase().equals(article.getWarehouseLocation().toLowerCase())) {
                String exceptionMessage = "Warehouse location ";
                exceptionMessage += entity.getWarehouseLocation();
                exceptionMessage += " is identical to the location of id ";
                exceptionMessage += article.getId();
                throw new InvoiceGeneratorException(exceptionMessage);
            }
        }
    }
}
