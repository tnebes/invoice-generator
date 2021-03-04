package invoiceGenerator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "status")
public class Status extends Identity {

	@Column(columnDefinition = "varchar(50)", nullable = false)
	private String 			name;

	@Column(columnDefinition = "varchar(100)")
	private String 			description;

	@Column(name = "description_long", columnDefinition = "text")
	private String 			descriptionLong;

	@Column(name = "invoices_id")
	@OneToMany(mappedBy = "status")
	private List<Invoice> invoices;

	public Status() {

	}

	public Status(String name, String description, String descriptionLong) {
		this.name = name;
		this.description = description;
		this.descriptionLong = descriptionLong;
		initialise();
	}

	private void initialise() {
		this.invoices = new ArrayList<>();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescriptionLong() {
		return descriptionLong;
	}
	public void setDescriptionLong(String descriptionLong) {
		this.descriptionLong = descriptionLong;
	}
	public List<Invoice> getInvoices() {
		return invoices;
	}
	public void setInvoices(ArrayList<Invoice> invoices) {
		this.invoices = invoices;
	}

	@Override
	public String toString() {
		return "Status{" +
				"id=" + super.getId() +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", descriptionLong='" + descriptionLong + '\'' +
				'}';
	}
}
