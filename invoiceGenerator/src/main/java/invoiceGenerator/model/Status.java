package invoiceGenerator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "status")
public class Status extends Identity {

	@NotNull(message = "A status must have a name")
	@Size(max = 50)
	@Column
	private String 			name;

	@Size(max = 100)
	@Column
	private String 			description;

	@Column(name = "description_long", columnDefinition = "text")
	private String 			descriptionLong;

	@Column(name = "invoices_id")
	@OneToMany(mappedBy = "status")
	private List<Invoice> invoices = new ArrayList<>();

	public Status() {

	}

	public Status(String name, String description, String descriptionLong) {
		this();
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
		return this.getName();
	}

	// absolutely cursed
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Status status = (Status) o;
		return Objects.equals(name, status.name) && Objects.equals(description, status.description) && Objects.equals(descriptionLong, status.descriptionLong);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, description, descriptionLong);
	}
}
