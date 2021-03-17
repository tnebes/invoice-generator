package invoiceGenerator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "article")
public class Article extends Identity {

	static public final byte STANDARD_TAX_RATE = 25;

	@NotNull(message = "Warehouse location must be set.")
	@NotEmpty(message = "Warehouse location must not be empty.")
	@Size(max = 10, message = "Location can be maximally 10 characters.")
	@Column(name = "warehouse_location")
	private String		warehouseLocation; // not null

	@NotNull(message = "Quantity cannot be null.")
	@Column(name = "warehouse_quantity")
	private Long 		warehouseQuantity = 0L; // not null

	@NotNull(message = "Wholesale price cannot be null.")
	@Column(name = "wholesale_price")
	private BigDecimal 	wholesalePrice; // not null

	@NotNull(message = "Retail price cannot be null.")
	@Column(name = "retail_price")
	private BigDecimal	retailPrice;

	@NotNull(message = "Tax rate cannot be null.")
	@Column(name = "tax_rate")
	private BigDecimal	taxRate = BigDecimal.valueOf(STANDARD_TAX_RATE);

	@NotNull(message = "Article must have a short name.")
	@NotEmpty(message = "Article cannot have a blank or empty name.")
	@Size(max = 50)
	@Column(name = "short_name")
	private String 		shortName; // not null

	@Size(max = 100)
	@Column(name = "long_name")
	private String 		longName;

	@Size(max = 100)
	@Column(name = "short_description")
	private String 		shortDescription;

	@Column(name = "long_description", columnDefinition = "text")
	private String 		longDescription;

	// TODO delete this?
	@Column(name = "article_invoice")
	@OneToMany(mappedBy = "article")
	private List<ArticleInvoice> articleInvoice = new ArrayList<>();

	public Article() {
	}

	// TODO article constructor with arguments?

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
	public BigDecimal getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}
	public BigDecimal getCalculableTaxRate() {
		return getTaxRate().divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
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

	@Override
	public String toString() {
            return this.getId() + " - " + this.getShortName() + " : " + this.getWarehouseQuantity();
	}
}
