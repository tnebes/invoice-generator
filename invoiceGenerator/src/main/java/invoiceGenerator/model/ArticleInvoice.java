package invoiceGenerator.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Instant;

@Entity(name = "article_invoice")
public class ArticleInvoice extends Identity {

	@NotNull(message = "Date must exist.")
	@Column(name = "date_of_creation")
	private Instant 	dateOfCreation;

	@ManyToOne()
	@NotNull(message = "Requires an article.")
	@JoinColumn(name = "article")
	private Article		article;

	@ManyToOne()
	@NotNull(message = "Requires an invoice.")
	@JoinColumn(name = "invoice")
	private Invoice		invoice;

	@NotNull(message = "A nonnegative discount must exist")
	// TODO non-negative number
	private BigDecimal	discount = BigDecimal.ZERO;

	@NotNull(message = "Quantity must be defined")
	private Long 		quantity;

	@NotNull(message = "Wholesale price must be defined.")
	@Column(name = "wholesale_price")
	private BigDecimal 	wholesalePrice;

	@NotNull(message = "Retail price must be defined.")
	@Column(name = "retail_price")
	private BigDecimal 	retailPrice;

	@NotNull(message = "Tax rate must be defined.")
	@Column(name = "tax_rate")
	private BigDecimal	taxRate = BigDecimal.valueOf(25);

	@Column(columnDefinition = "text")
	private String 		note;

	public ArticleInvoice() {

	}

	public ArticleInvoice(Instant dateOfCreation, Article article, Invoice invoice,
						  BigDecimal discount, Long quantity, BigDecimal wholesalePrice,
						  BigDecimal retailPrice, BigDecimal taxRate, String note) {
		this();
		this.dateOfCreation = dateOfCreation;
		this.article = article;
		this.invoice = invoice;
		this.discount = discount;
		this.quantity = quantity;
		this.wholesalePrice = wholesalePrice;
		this.retailPrice = retailPrice;
		this.taxRate = taxRate;
		this.note = note;
	}

	public Instant getDateOfCreation() {
		return dateOfCreation;
	}
	public void setDateOfCreation(Instant dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public Invoice getInvoice() {
		return invoice;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	public BigDecimal getDiscount() {
		return discount;
	}
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getWholesalePrice() {
		return wholesalePrice;
	}
	public void setWholesalePrice(BigDecimal wholesalePrice) {
		this.wholesalePrice = wholesalePrice;
	}
	public BigDecimal getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(BigDecimal retailPrice) {
		this.retailPrice = retailPrice;
	}
	public BigDecimal getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
	
}
