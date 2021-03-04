package invoiceGenerator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "customer")
public class Customer extends Identity {

	static public final boolean NATURAL_PERSON = false;
	static public final boolean LEGAL_PERSON = true;
	@Column(nullable = false)
	private Boolean 			type;

	@Column(name = "date_of_creation", nullable = false)
	private Instant 			dateOfCreation;

	@Column(columnDefinition = "varchar(32)")
	private String 				VATID;

	@Column(name = "national_id_number", columnDefinition = "varchar(32)")
	private String 				nationalIdNumber;

	@Column(columnDefinition = "char(100)")
	private String 				name;

	@Column(name = "first_name", columnDefinition = "varchar(50)")
	private String 				firstName;

	@Column(name = "middle_name", columnDefinition = "varchar(50)")
	private String 				middleName;

	@Column(name = "last_name", columnDefinition = "varchar(50)")
	private String 				lastName;

	@ManyToOne
	private Address				billingAddress;

	@ManyToOne
	private Address 			shippingAddress;

//	// TODO
//	@OneToMany(targetEntity = Invoice.class, mappedBy = "customer")
//	private ArrayList<Invoice> invoices = new ArrayList<>();

	public Customer() {

	}

	public Customer(Boolean type, Instant dateOfCreation, String VATID, String nationalIdNumber, String name, String firstName, String middleName, String lastName, Address billingAddress, Address shippingAddress) {
		this.type = type;
		this.dateOfCreation = dateOfCreation;
		this.VATID = VATID;
		this.nationalIdNumber = nationalIdNumber;
		this.name = name;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
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
		StringBuilder sb = new StringBuilder();
		sb.append(super.getId()).append(" ");
		if (type == NATURAL_PERSON) {
			sb.append(firstName).append(" ").append(lastName).append(" ");
		} else {
			sb.append(name).append(" ");
		}
		return sb.toString();
	}
	
	
}
