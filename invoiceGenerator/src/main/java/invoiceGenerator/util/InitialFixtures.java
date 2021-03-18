package invoiceGenerator.util;

import com.github.javafaker.Faker;
import invoiceGenerator.controller.*;
import invoiceGenerator.model.*;
import org.mindrot.jbcrypt.BCrypt;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InitialFixtures {


    public InitialFixtures() {
        Faker faker = new Faker();
        Random rng = new Random();

        // operator
        Operator operator = new Operator();
        operator.setEmail("tnebes@drau.de");
        operator.setPassword(BCrypt.hashpw("edunova", BCrypt.gensalt()));
        operator.setFirstName("Tomislav");
        operator.setLastName("Nebes");
        OperatorHandler operatorHandler = new OperatorHandler();
        try {
            operatorHandler.setEntity(operator);
            operatorHandler.create();
        } catch (InvoiceGeneratorException e) {
            e.printStackTrace();
        }

        // address check
        List<Address> addresses = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
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
            testArticle.setTaxRate(BigDecimal.valueOf(rng.nextInt(25)));
            testArticle.setRetailPrice(testArticle.getWholesalePrice().multiply(testArticle.getCalculableTaxRate().add(BigDecimal.ONE)).setScale(2, RoundingMode.HALF_UP));
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
            naturalCustomer.setFirstName(faker.pokemon().name());
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
        Status testStatus = new Status();
        StatusHandler statusHandler = new StatusHandler();
        testStatus.setName("Cash");
        testStatus.setDescription("Paid in cash");
        testStatus.setDescriptionLong("When a customer comes in and pays in cash.");
        try {
            statusHandler.setEntity(testStatus);
            statusHandler.create();
        } catch (InvoiceGeneratorException e) {
            e.printStackTrace();
        }

        // transaction type check
        TransactionType transactionType = new TransactionType();
        TransactionTypeHandler transactionTypeHandler = new TransactionTypeHandler();
        transactionType.setName("Processing");
        transactionType.setDescription("Paid, being processed.");
        try {
            transactionTypeHandler.setEntity(transactionType);
            transactionTypeHandler.create();
        } catch (InvoiceGeneratorException e ) {
            e.printStackTrace();
        }
        // invoice check

    }

}
