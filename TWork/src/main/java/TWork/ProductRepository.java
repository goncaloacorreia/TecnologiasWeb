package TWork;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

	List<Product> findAllByBrandAndPrice(String name, String price);

	List<Product> findOneByName(String name);

	List <Product> findAllByName(String name);
	List <Product> findAllByBrand(String brand);

	void deleteById(Long id);
	
	Client findById(long id);
}
