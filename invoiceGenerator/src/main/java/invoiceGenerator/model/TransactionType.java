package invoiceGenerator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.ArrayList;

@Entity(name = "transaction_type")
public class TransactionType extends Identity {

	@Column(columnDefinition = "varchar(100)")
	private String 				name;

	@Column(columnDefinition = "varchar(255)")
	private String 				description;

	public TransactionType() {
		// this(IDCounter.incrementTransactionTypeCounter(), "default", "default");
	}

	public TransactionType(String name, String description) {
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
