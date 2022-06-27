package TWork;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;

@Controller
public class NewOrderController {

	private static final Logger log = LoggerFactory.getLogger(NewOrderController.class);

    @Autowired
    private OrderRepository repository;

	@Autowired
	private ClientRepository repository1;
    
	@PostMapping("/order") // encomendar na product page
	public String newOrder(
		@RequestParam(name="product", required=false) String product,
		@RequestParam(name="units", required=false) String units,
		@RequestParam(name="size", required=false) String size,
		@RequestParam(name="user", required=false) String user,
		Model model) 
			
	{
		Client client = repository1.findOneByUsername(user);

		repository.save(new Order(product, units, size, client));
		
		
		
		
		log.info("Orders found with findAll():");
		log.info("-------------------------------");
		for (Order order : repository.findAll()) {
			log.info(order.toString());
		}
		log.info("");
		
		model.addAttribute("product", product);
		return "new-order-view";
	}

	@PostMapping("/order1") // listar encomendas
	public String newOrder(
		@RequestParam(name="user", required=false) String user,
		Model model) 
			
	{
		Client client = repository1.findOneByUsername(user);
		List<Order> orderList = repository.findAllByClient(client);

		log.info("Orders found with findAll():");
		log.info("-------------------------------");
		for (Order order : repository.findAll()) {
			log.info(order.toString());
		}

		log.info("");

		model.addAttribute("orderList", orderList);
		return "orders-view";
	}
	
}