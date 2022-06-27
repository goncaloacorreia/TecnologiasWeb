package TWork;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "order_table")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String product;
	private String units;
	private String size;
	
	@ManyToOne
    @JoinColumn(name="client_id")
    private Client client;

	protected Order() {}

	public Order(String product, String units, String size, Client client) {
		this.product = product;
		this.units = units;
		this.size = size;
		this.client = client;
		
	}

	@Override
	public String toString() {
		return String.format(
				"Order[id=%d, product = '%s', units = '%s', size = '%s',client = '%s']",
				id, product, units, size, client);
	}

	public Long getId() {
		return id;
	}

	public String getProduct() {
		return product;
	}

	public String getUnits() {
		return units;
	}

	public String getSize() {
		return size;
	}
	
}