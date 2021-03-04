package invoiceGenerator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "article")
public class Article extends Identity {

	static public final byte STANDARD_TAX_RATE = 25;

	@Column(name = "warehouse_location", columnDefinition = "varchar(10)", nullable = false)
	private String		warehouseLocation; // not null

	@Column(name = "warehouse_quantity", nullable = false)
	private Long 		warehouseQuantity; // not null

	@Column(name = "wholesale_price", nullable = false)
	private BigDecimal 	wholesalePrice; // not null

	@Column(name = "retail_price", nullable = false)
	private BigDecimal	retailPrice;

	@Column(name = "tax_rate", nullable = false)
	private Byte 		taxRate;

	@Column(name = "short_name", columnDefinition = "varchar(50)", nullable = false)
	private String 		shortName; // not null

	@Column(name = "long_name", columnDefinition = "varchar(100)")
	private String 		longName;

	@Column(name = "short_description", columnDefinition = "varchar(100)")
	private String 		shortDescription;

	@Column(name = "long_description", columnDefinition = "text")
	private String 		longDescription;

	// TODO delete this?
	@Column(name = "article_invoice")
	@OneToMany(mappedBy = "article")
	private List<ArticleInvoice> articleInvoice;

	public Article() {

	}

	public Article(String warehouseLocation, Long warehouseQuantity, BigDecimal wholesalePrice, BigDecimal retailPrice, Byte taxRate, String shortName, String longName, String shortDescription, String longDescription) {
		this.warehouseLocation = warehouseLocation;
		this.warehouseQuantity = warehouseQuantity;
		this.wholesalePrice = wholesalePrice;
		this.retailPrice = retailPrice;
		this.taxRate = taxRate;
		this.shortName = shortName;
		this.longName = longName;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
	}

	public String getWarehouseLocation() {
		return warehouseLocation;
	}
	public void setWarehouseLocation(String warehouseLocation) {
		this.warehouseLocation = warehouseLocation;
	}
	public Long getWarehouseQuantity() {
		return warehouseQuantity;
	}
	public void setWarehouseQuantity(Long warehouseQuantity) {
		this.warehouseQuantity = warehouseQuantity;
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
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getLongName() {
		return longName;
	}
	public void setLongName(String longName) {
		this.longName = longName;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getLongDescription() {
		return longDescription;
	}
	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

}
