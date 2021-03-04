package invoiceGenerator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "transaction_type")
public class TransactionType extends Identity {

	@Size(max = 100)
	@NotNull(message = "Transaction type must have a name.")
	@NotEmpty(message = "Transaction type's name cannot be blank or empty.")
	@Column
	private String 				name;

	@Size(max = 255)
	@Column
	private String 				description;

	public TransactionType() {

	}

	public TransactionType(String name, String description) {
		this();
		this.name = name;
		this.description = description;
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

	@Override
	public String toString() {
		return "TransactionType{" +
				"id=" + super.getId() +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				'}';
	}
}
