package invoiceGenerator.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity(name = "article_invoice")
public class ArticleInvoice extends Identity {

	@Column(name = "date_of_creation", nullable = false)
	private Instant 	dateOfCreation;

	@ManyToOne()
	@JoinColumn(name = "article", nullable = false)
	private Article		article;

	@ManyToOne()
	@JoinColumn(name = "invoice", nullable = false)
	private Invoice		invoice;

	private Byte 		discount;

	@Column(nullable = false)
	private Long 		quantity;

	@Column(name = "wholesale_price", nullable = false)
	private BigDecimal 	wholesalePrice;

	@Column(name = "retail_price", nullable = false)
	private BigDecimal 	retailPrice;

	@Column(name = "tax_rate", nullable = false)
	private Byte 		taxRate;

	@Column(columnDefinition = "text")
	private String 		note;
	
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
	public Byte getDiscount() {
		return discount;
	}
	public void setDiscount(Byte discount) {
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
	public Byte getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(Byte taxRate) {
		this.taxRate = taxRate;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
	
}
