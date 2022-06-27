package TWork;

import org.springframework.data.repository.CrudRepository;
import java.util.*;

public interface OrderRepository extends CrudRepository<Order, Long> {

	List <Order> findAllByClient(Client client);
	Order findById(long id);
}
