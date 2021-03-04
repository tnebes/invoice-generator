package invoiceGenerator.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author tnebes
 * @date 6 February 2021
 */

@Entity(name = "invoice")
public class Invoice extends Identity {

	@NotNull(message = "Date of creation cannot be null.")
	@Column(name = "date_of_creation")
	private Instant				dateOfCreation; // not null

	@ManyToOne(targetEntity = Customer.class, optional = true)
	private Customer			customer;

	@NotNull(message = "An invoice must have a transaction type.")
	@ManyToOne
	private TransactionType 	transactionType; // not null

	@NotNull(message = "An invoice must have a status.")
	@ManyToOne
	private Status				status; // not null

	@NotNull(message = "An invoice must have a not null value for discount.")
	@Column(name = "invoice_discount_percent")
	private Byte 				invoiceDiscountPercent = 0;

	@NotNull(message = "An invoice must have a subtotal (total - tax)")
	@Column
	private BigDecimal			subtotal;

	@NotNull(message = "An invoice must have total")
	@Column
	private BigDecimal			total;

	@NotNull(message = "An invoice must have the amount due.")
	@Column(name = "amount_due", nullable = false)
	private BigDecimal			amountDue;

	@NotNull(message = "An invoice must have some amount paid.")
	@Column(name = "amount_paid", nullable = false)
	private BigDecimal			amountPaid; // not null

	@ManyToOne(optional = true)
	private Address				shippingAddress;

	// TODO delete this?
	@Column(name = "article_invoice")
	@OneToMany(mappedBy = "invoice")
	List<ArticleInvoice> articleInvoice = new ArrayList<>();

	public Invoice() {

	}

	public Invoice(Instant dateOfCreation, Customer customer, TransactionType transactionType,
				   Status status, Byte invoiceDiscountPercent, BigDecimal subtotal, BigDecimal total,
				   BigDecimal amountDue, BigDecimal amountPaid, Address shippingAddress) {
		this();
		this.dateOfCreation = dateOfCreation;
		this.customer = customer;
		this.transactionType = transactionType;
		this.status = status;
		this.invoiceDiscountPercent = invoiceDiscountPercent;
		this.subtotal = subtotal;
		this.total = total;
		this.amountDue = amountDue;
		this.amountPaid = amountPaid;
		this.shippingAddress = shippingAddress;
	}

	public Instant getDateOfCreation() {
		return dateOfCreation;
	}
	public void setDateOfCreation(Instant dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public TransactionType getTransactionTypeId() {
		return transactionType;
	}
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Byte getInvoiceDiscountPercent() {
		return invoiceDiscountPercent;
	}
	public void setInvoiceDiscountPercent(Byte invoiceDiscountPercent) {
		this.invoiceDiscountPercent = invoiceDiscountPercent;
	}
	public BigDecimal getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}
	public BigDecimal getAmountDue() {
		return amountDue;
	}
	public void setAmountDue(BigDecimal amountDue) {
		this.amountDue = amountDue;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public BigDecimal getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(BigDecimal amountPaid) {
		this.amountPaid = amountPaid;
	}
	public Address getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}


	@Override
	public String toString() {
		return "Invoice{" +
				"dateOfCreation=" + dateOfCreation +
				", customer=" + customer +
				", transactionType=" + transactionType +
				", status=" + status +
				", invoiceDiscountPercent=" + invoiceDiscountPercent +
				", subtotal=" + subtotal +
				", total=" + total +
				", amountDue=" + amountDue +
				", amountPaid=" + amountPaid +
				", shippingAddress=" + shippingAddress +
				'}';
	}
}
