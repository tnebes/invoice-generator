package invoiceGenerator.util;

import com.github.javafaker.Faker;
import invoiceGenerator.controller.AddressHandler;
import invoiceGenerator.controller.ArticleHandler;
import invoiceGenerator.controller.CustomerHandler;
import invoiceGenerator.model.Address;
import invoiceGenerator.model.Article;
import invoiceGenerator.model.Customer;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InitialFixtures {


    public InitialFixtures() {
        Faker faker = new Faker();
        Random rng = new Random();

        // address check
        List<Address> addresses = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
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
                addresses.add(testAddress);
            } catch (InvoiceGeneratorException e) {
                e.printStackTrace();
            }
        }
        // article check
        List<Article> articles = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Article testArticle = new Article();
            testArticle.setLongDescription(faker.animal().name());
            testArticle.setLongName(faker.app().name());
            testArticle.setShortDescription(faker.ancient().titan());
            testArticle.setShortName(faker.cat().name());
            testArticle.setWholesalePrice(BigDecimal.valueOf(rng.nextDouble() * 1000));
            testArticle.setTaxRate((byte) rng.nextInt(25));
            testArticle.setRetailPrice(testArticle.getWholesalePrice().multiply(BigDecimal.valueOf((testArticle.getTaxRate() / 100.0) + 1)));
            testArticle.setWarehouseLocation(faker.bothify("?#-?#"));
            testArticle.setWarehouseQuantity((long) rng.nextInt(250));
            ArticleHandler articleHandler = new ArticleHandler();
            try {
                articleHandler.setEntity(testArticle);
                articleHandler.create();
                articles.add(testArticle);
            } catch (InvoiceGeneratorException e) {
                e.printStackTrace();
            }
        }
        // natural customer check
        int addressCounter = 0;
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Customer naturalCustomer = new Customer();
            CustomerHandler customerHandler = new CustomerHandler();
            naturalCustomer.setDateOfCreation(Instant.now());
            naturalCustomer.setFirstName(faker.name().firstName());
            if (rng.nextBoolean()) {
                naturalCustomer.setMiddleName(faker.name().firstName());
            }
            naturalCustomer.setLastName(faker.name().lastName());
            if (rng.nextBoolean()) {
                naturalCustomer.setNationalIdNumber(faker.idNumber().valid());
            }
            naturalCustomer.setBillingAddress(addresses.get(addressCounter++));
            try {
                customerHandler.setEntity(naturalCustomer);
                customerHandler.create();
                customers.add(naturalCustomer);
            } catch (InvoiceGeneratorException e) {
                e.printStackTrace();
            }
        }
        // legal customer check
        for (int i = 0; i < 10; i++) {
            Customer legalCustomer = new Customer();
            CustomerHandler customerHandler = new CustomerHandler();
            legalCustomer.setType(Customer.LEGAL_PERSON);
            legalCustomer.setDateOfCreation(Instant.now());
            legalCustomer.setName(faker.company().name());
            legalCustomer.setVATID(faker.idNumber().valid());
            legalCustomer.setBillingAddress(addresses.get(addressCounter++));
            try {
                customerHandler.setEntity(legalCustomer);
                customerHandler.create();
                customers.add(legalCustomer);
            } catch (InvoiceGeneratorException e) {
                e.printStackTrace();
            }
        }
        // status check

        // transaction type check

        // invoice check
        
    }

}
