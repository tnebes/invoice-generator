package invoiceGenerator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "customer")
public class Customer extends Identity {

	static public final boolean LEGAL_PERSON = true;
	static public final boolean NATURAL_PERSON = false;

	@NotNull(message = "Type must be defined")
	private Boolean 			type = NATURAL_PERSON; // 1 legal, 0 natural person

	@NotNull(message = "Customer must have date of creation assigned.")
	@Column(name = "date_of_creation")
	private Instant 			dateOfCreation;

	@Size(max = 32)
	@Column(name = "vatid")
	private String 				VATID;

	@Size(max = 32)
	@Column(name = "national_id_number")
	private String 				nationalIdNumber;

	@Size(max = 32)
	private String 				name;

	@Size(max = 50)
	@Column(name = "first_name")
	private String 				firstName;

	@Size(max = 50)
	@Column(name = "middle_name")
	private String 				middleName;

	@Size(max = 50)
	@Column(name = "last_name")
	private String 				lastName;

	@ManyToOne(optional = false)
	private Address				billingAddress;

	@ManyToOne
	private Address 			shippingAddress;

	public Customer() {

	}

	public Customer(Instant dateOfCreation, String nationalIdNumber, String firstName,
					String middleName, String lastName, Address billingAddress,
					Address shippingAddress) {
		this();
		this.type = Customer.NATURAL_PERSON;
		this.dateOfCreation = dateOfCreation;
		this.nationalIdNumber = nationalIdNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.billingAddress = billingAddress;
		this.shippingAddress = shippingAddress;
	}

	public Customer(@NotNull(message = "Customer must have date of creation assigned.") Instant dateOfCreation,
					@Size(max = 32) String VATID,
					@Size(max = 32) String name,
					Address billingAddress, Address shippingAddress) {
		this();
		this.dateOfCreation = dateOfCreation;
		this.VATID = VATID;
		this.name = name;
		this.billingAddress = billingAddress;
		this.shippingAddress = shippingAddress;
	}

	public Boolean isType() {
		return type;
	}
	public void setType(Boolean type) {
		this.type = type;
	}
	public Instant getDateOfCreation() {
		return dateOfCreation;
	}
	public void setDateOfCreation(Instant dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
	public String getVATID() {
		return VATID;
	}
	public void setVATID(String VATID) {
		this.VATID = VATID;
	}
	public String getNationalIdNumber() {
		return nationalIdNumber;
	}
	public void setNationalIdNumber(String nationalIdNumber) {
		this.nationalIdNumber = nationalIdNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Address getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
	public Address getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
//	public List<Invoice> getInvoices() {
//		return invoices;
//	}
//
//	public void setInvoices(ArrayList<Invoice> invoices) {
//		this.invoices = invoices;
//	}
        
        @Override
        public String toString() {
            String returnString = this.getId() + " - ";
            if (this.isType() == Customer.NATURAL_PERSON) {
                returnString += this.getFirstName() + " " + this.getLastName();
            } else {
                returnString += this.getName() + " " + this.getVATID();
            }
            return returnString;
        }

        @Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Customer customer = (Customer) o;
		return Objects.equals(customer.getId(), this.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getId());
	}

}
