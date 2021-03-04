package invoiceGenerator.util;

import com.github.javafaker.Faker;
import invoiceGenerator.controller.AddressHandler;
import invoiceGenerator.controller.ArticleHandler;
import invoiceGenerator.model.Address;
import invoiceGenerator.model.Article;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Random;

public class InitialFixtures {


    public InitialFixtures() {
        Faker faker = new Faker();
        Random rng = new Random();

        // address check
        for (int i = 0; i < 10; i++) {
            Address testAddress = new Address();
            testAddress.setZIPCode(faker.address().zipCode());
            testAddress.setCity(faker.address().city());
            testAddress.setCountry(faker.country().name());
            testAddress.setStreet(faker.address().streetName());
            testAddress.setStreetNumber(faker.address().streetAddressNumber());
            testAddress.setStreetLetter(faker.letterify("?"));
            testAddress.setType(rng.nextBoolean());
            AddressHandler addressHandler = new AddressHandler();
            try {
                addressHandler.setEntity(testAddress);
                addressHandler.create();
            } catch (InvoiceGeneratorException e) {
                e.printStackTrace();
            }
        }
        // article check
        for (int i = 0; i < 10; i++) {
            Article testArticle = new Article();
            testArticle.setLongDescription(faker.animal().name());
            testArticle.setLongName(faker.app().name());
            testArticle.setShortDescription(faker.ancient().titan());
            testArticle.setShortName(faker.cat().name());
            testArticle.setWholesalePrice(BigDecimal.valueOf(rng.nextDouble() * 1000));
            testArticle.setTaxRate((byte) 25);
            testArticle.setRetailPrice(testArticle.getWholesalePrice().multiply(BigDecimal.valueOf(testArticle.getTaxRate())));
            testArticle.setWarehouseLocation(faker.bothify("?#-?#"));
            testArticle.setWarehouseQuantity(rng.nextLong());
            ArticleHandler articleHandler = new ArticleHandler();
            try {
                articleHandler.setEntity(testArticle);
                articleHandler.create();
            } catch (InvoiceGeneratorException e) {
                e.printStackTrace();
            }
        }

    }

}
