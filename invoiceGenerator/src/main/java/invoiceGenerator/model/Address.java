package invoiceGenerator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "address")
public class Address extends Identity {

	static public final boolean SHIPPING_ADDRESS = false;
	static public final boolean BILLING_ADDRESS = true;

	private Boolean					type;
	@Column(columnDefinition = "varchar(50)", nullable = false)
	private String city;

	@Column(name = "ZIP_code", columnDefinition = "varchar(50)", nullable = false)
	private String					ZIPCode;

	@Column(columnDefinition = "char(50)", nullable = false)
	private String					street;

	@Column(name = "street_number", columnDefinition = "varchar(10)")
	private String					streetNumber;

	@Column(name = "street_letter", columnDefinition = "varchar(10)")
	private String					streetLetter;

	@Column(columnDefinition = "varchar(50)", nullable = false)
	private String					country;

	public Address(Boolean type, String city, String ZIPCode, String street, String streetNumber, String streetLetter, String country) {
		this.type = type;
		this.city = city;
		this.ZIPCode = ZIPCode;
		this.street = street;
		this.streetNumber = streetNumber;
		this.streetLetter = streetLetter;
		this.country = country;
	}

	public Address() {

	}

	public Boolean isType() {
		return type;
	}
	public void setType(Boolean type) {
		this.type = type;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZIPCode() {
		return ZIPCode;
	}
	public void setZIPCode(String ZIPCode) {
		this.ZIPCode = ZIPCode;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	public String getStreetLetter() {
		return streetLetter;
	}
	public void setStreetLetter(String streetLetter) {
		this.streetLetter = streetLetter;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

//	public List<Invoice> getInvoices() {
//		return invoices;
//	}
//	public void setInvoices(List<Invoice> invoiceIDs) {
//		this.invoices = invoices;
//	}
	
	
	
}
