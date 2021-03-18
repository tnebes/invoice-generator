package invoiceGenerator.controller;

import invoiceGenerator.model.Article;
import invoiceGenerator.util.InvoiceGeneratorException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class ArticleHandler extends Handler<Article> {


    public ArticleHandler(Article entity) {
        super(entity);
    }

    public ArticleHandler() {

    }

    @Override
    public List<Article> getData() throws InvoiceGeneratorException {
        return session.createQuery("from article").list();
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
        if (entity.getTaxRate().compareTo(BigDecimal.ZERO) < 0) {
            throw new InvoiceGeneratorException("Tax rate cannot be negative.");
        }
        if (entity.getRetailPrice().compareTo(entity.getWholesalePrice()
                .multiply(entity.getCalculableTaxRate()
                        .add(BigDecimal.ONE)).setScale(2, RoundingMode.HALF_UP)) != 0) {
            String exceptionMessage = String.format(new String("Price difference between retail and wholesale * tax rate detected.\n" +
                    "Retail: %f; tax rate: %f wholesale: %f"),entity.getRetailPrice(), entity.getTaxRate(), entity.getWholesalePrice() );
            throw new InvoiceGeneratorException(exceptionMessage);
        }
    }

    private void warehouseCheck() throws InvoiceGeneratorException {
        if (entity.getWarehouseQuantity() < 0) {
            throw new InvoiceGeneratorException("Quantity cannot be negative.");
        }
        List<Article> articles = new ArticleHandler(entity).getData();
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
