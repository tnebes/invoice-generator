package invoiceGenerator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
		return this.getName();
	}

	// absolutely cursed
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TransactionType that = (TransactionType) o;
		return Objects.equals(name, that.name) && Objects.equals(description, that.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, description);
	}
}
