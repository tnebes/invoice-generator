package invoiceGenerator.dataHandler;

import invoiceGenerator.model.*;

import java.util.ArrayList;

public class Memory {

    private static ArrayList<Address> addresses;
    private static ArrayList<Article> articles;
    private static ArrayList<ArticleInvoice> articleInvoices;
    private static ArrayList<Customer> customers;
    private static ArrayList<Invoice> invoices;
    private static ArrayList<Status> statuses;
    private static ArrayList<TransactionType> transactionTypes;

    public static ArrayList<Address> getAddresses() {
        return addresses;
    }

    public static void setAddresses(ArrayList<Address> addresses) {
        Memory.addresses = addresses;
    }

    public static ArrayList<Article> getArticles() {
        return articles;
    }

    public static void setArticles(ArrayList<Article> articles) {
        Memory.articles = articles;
    }

    public static ArrayList<ArticleInvoice> getArticleInvoices() {
        return articleInvoices;
    }

    public static void setArticleInvoices(ArrayList<ArticleInvoice> articleInvoices) {
        Memory.articleInvoices = articleInvoices;
    }

    public static ArrayList<Customer> getCustomers() {
        return customers;
    }

    public static void setCustomers(ArrayList<Customer> customers) {
        Memory.customers = customers;
    }

    public static ArrayList<Invoice> getInvoices() {
        return invoices;
    }

    public static void setInvoices(ArrayList<Invoice> invoices) {
        Memory.invoices = invoices;
    }

    public static ArrayList<Status> getStatuses() {
        return statuses;
    }

    public static void setStatuses(ArrayList<Status> statuses) {
        Memory.statuses = statuses;
    }

    public static ArrayList<TransactionType> getTransactionTypes() {
        return transactionTypes;
    }

    public static void setTransactionTypes(ArrayList<TransactionType> transactionTypes) {
        Memory.transactionTypes = transactionTypes;
    }
}
