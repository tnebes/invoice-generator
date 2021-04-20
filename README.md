# Java Swing Based Invoice Generator

The invoice generator is a simple Swing based application useful for small businesses who wish to track their products, customers and invoices. The program is intuitive to use and is extremely lightweight. The Invoice Generator connects to a MariaDB database and handles all the accounting and sales data. The primary advantage of this program is its versatility and redundancy.

## Features

### Authorisation

Each user can have their own user account with which they can use the program.

![authorisation menu](https://github.com/tnebes/invoice-generator/blob/master/media/authorisation.png?raw=true)

### Register

Invoices are created from the register tab where the users can assign a customer, a shipping address, and articles to the invoice. Additionally, an invoice can have a status and transaction type assigned so that orders can be tracked.

![register tab](https://github.com/tnebes/invoice-generator/blob/master/media/register.png?raw=true)

### Customers

The program allows the user to maintain a list of customers and add, change, or remove customers.

![customer tab](https://github.com/tnebes/invoice-generator/blob/master/media/customers.png?raw=true)

#### Addresses

The customer can have a billing as well as a shipping address. The program tracks both and connects it to any invoice.

### Articles

Since every store needs something to sell, the users can add, change or remove articles. Embedded within is a useful calculator for calculating any three values if the previous two are known: Wholesale, tax rate, and retail price.

![articles tab](https://github.com/tnebes/invoice-generator/blob/master/media/articles.png?raw=true)

### Invoices

After an invoice is issued, the user can remove articles from the invoice or change them.

![invoices](https://github.com/tnebes/invoice-generator/blob/master/media/invoices.png?raw=true)

### Transactions and Statuses

In order to more precisely track invoices, invoices can be filtered according to their status and transaction type. Additionally, the user can add their own status and transaction types.

![transactions and statuses](https://github.com/tnebes/invoice-generator/blob/master/media/transactionStatus.png?raw=true)

## Credits

I would like to thank my family for their support.

I would like to thank my dear colleague, [@iva-i](https://github.com/iva-i), for helping me design the program, making sure it is bug free and generally being great moral support.

I would additionally like to thank my teacher and mentor, [@tjakopec](https://github.com/tjakopec) for teaching me SQL and Java. He has provided me with plenty of useful information, tips and tricks to make the program run better.

# Feedback

If you want some help using this program, or have any questions regarding it, please shoot me a message on github.