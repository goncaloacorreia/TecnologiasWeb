package TWork;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
    private String name;
    private String brand;
	private String desc;
    private String price;
    private String release_date;
    private String stock_limit;
		
	protected Product() {}

	public Product(String name, String brand, String desc, String price, String release_date, String stock_limit) {
        this.name = name;
        this.brand = brand;
        this.desc = desc;
        this.price = price;
        this.release_date = release_date;
        this.stock_limit = stock_limit;
	}

	@Override
	public String toString() {
		return String.format(
				"Product[id=%d, name = '%s', brand = '%s', desc = '%s', price = '%s', release_date = '%s', stock_limit = '%s']",
				id, name, brand, desc, price, release_date, stock_limit);
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
    }
    
    public String getBrand() {
		return brand;
	}

	public String getDesc() {
		return desc;
	}

	public String getPrice() {
		return price;
    }
    
    public String getRelease_date() {
		return release_date;
	}

    public String getStock_limit() {
		return stock_limit;
	}

	
}
