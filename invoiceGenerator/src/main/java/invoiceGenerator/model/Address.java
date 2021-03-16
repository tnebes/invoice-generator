package invoiceGenerator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity(name = "address")
public class Address extends Identity {

	static public final boolean BILLING_ADDRESS = true;
	static public final boolean SHIPPING_ADDRESS = false;

	@NotNull(message = "address must be either a billing or shipping address.")
	private Boolean					type; // 1 billing, 0 shipping

	@NotNull(message = "Please enter a city.")
	@NotEmpty(message = "City cannot be blank or empty.")
	@Size(max = 50, message = "City name can be maximally 50 characters.")
	private String 					city;

	@NotNull(message = "Please enter a zip code.")
	@NotEmpty(message = "zip code cannot be blank or empty.")
	@Size(max = 50, message = "zip code can be maximally 50 characters.")
	@Column(name = "zip_code")
	private String					ZIPCode;

	@NotNull(message = "Please enter a street.")
	@NotEmpty(message = "Street name cannot be blank or empty.")
	@Size(max = 50, message = "Street name can be maximally 50 characters.")
	private String					street;

	@NotNull(message = "Please enter the street number.")
	@NotEmpty(message = "Street number cannot be blank or empty.")
	@Size(max = 10, message = "Street numbr can be maximally 10 characters.")
	@Column(name = "street_number")
	private String					streetNumber;

	@Size(max = 10, message = "Street letter can be maximally 10 characters.")
	@Column(name = "street_letter")
	private String					streetLetter;

	@NotNull(message = "Please enter a country.")
	@NotEmpty(message = "country cannot be blank or empty.")
	@Size(max = 100, message = "Country name can be maximally 100 characters.")
	private String					country;

	public Address() {
	}

	public Address(@NotNull(message = "address must be either a billing or shipping address.") Boolean type,
				   @NotNull(message = "Please enter a city.") @NotEmpty(message = "City cannot be blank or empty.") @Size(max = 50, message = "City name can be maximally 50 characters.") String city,
				   @NotNull(message = "Please enter a zip code.") @NotEmpty(message = "zip code cannot be blank or empty.") @Size(max = 50, message = "zip code can be maximally 50 characters.") String ZIPCode,
				   @NotNull(message = "Please enter a street.") @NotEmpty(message = "Street name cannot be blank or empty.") @Size(max = 50, message = "Street name can be maximally 50 characters.") String street,
				   @NotNull(message = "Please enter the street number.") @NotEmpty(message = "Street number cannot be blank or empty.") @Size(max = 10, message = "Street numbr can be maximally 10 characters.") String streetNumber,
				   @Size(max = 10, message = "Street letter can be maximally 10 characters.") String streetLetter,
				   @NotNull(message = "Please enter a country.") @NotEmpty(message = "country cannot be blank or empty.") @Size(max = 50, message = "Country name can be maximally 50 characters.") String country) {
		this();
		this.type = type;
		this.city = city;
		this.ZIPCode = ZIPCode;
		this.street = street;
		this.streetNumber = streetNumber;
		this.streetLetter = streetLetter;
		this.country = country;
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

	@Override
	public String toString() {
		return "Address{" +
				"type=" + type +
				", city='" + city + '\'' +
				", ZIPCode='" + ZIPCode + '\'' +
				", street='" + street + '\'' +
				", streetNumber='" + streetNumber + '\'' +
				", streetLetter='" + streetLetter + '\'' +
				", country='" + country + '\'' +
				'}';
	}
}
