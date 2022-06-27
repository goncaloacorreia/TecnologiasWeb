package TWork;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NewProductController {

	private static final Logger log = LoggerFactory.getLogger(NewProductController.class);

    @Autowired
    private ProductRepository repository;
    
	@PostMapping("/admin") //registar novo produto
	public String newProduct(
		@RequestParam(name="name", required=false, defaultValue="Nenhum produto adicionado") String name,
		@RequestParam(name="brand", required=false, defaultValue="World") String brand,
		@RequestParam(name="desc", required=false, defaultValue="World") String desc,
		@RequestParam(name="price", required=false, defaultValue="World") String price,
		@RequestParam(name="release_date", required=false, defaultValue="World") String release_date,
		@RequestParam(name="stock_limit", required=false, defaultValue="World") String stock_limit,
		Model model) 
	{
		
		repository.save(new Product(name, brand, desc, price, release_date, stock_limit));

		List<Product> productList = (List<Product>) repository.findAll();

		log.info("Products found with findAll():");
		log.info("-------------------------------");
		for (Product product : repository.findAll()) {
			log.info(product.toString());
		}

		log.info("");

		model.addAttribute("name", name);
		model.addAttribute("productList", productList);
		return "admin-view";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
		private String deleteProduct(@RequestParam String id){
		long num = Long.parseLong(id);
		repository.deleteById(num);
    	return "admin";
	}

	@PostMapping("/admin1") //ver list de produtos
	public String newProduct(Model model) 
	{
		
		List<Product> productList = (List<Product>) repository.findAll();

		log.info("Products found with findAll():");
		log.info("-------------------------------");
		for (Product product : repository.findAll()) {
			log.info(product.toString());
		}

		log.info("");

		model.addAttribute("productList", productList);
		return "admin-view";
	}

	@PostMapping("/index") //search bar
	public String newProduct(
		@RequestParam(name="search", required=false) String search,
		Model model) 
	{

		log.info("Customers found with findAll():");
		log.info("-------------------------------");
		for (Product product : repository.findAll()) {
			log.info(product.toString());
		}

		log.info("");
		
		List<Product> produto = repository.findAllByName(search);
		
		model.addAttribute("produto", produto);
		
		return "product-list";
	}

	@PostMapping("/index1") //categorias / adv search
	public String newProductBrand(
		@RequestParam(name="marca", required=false) String marca,
		Model model) 
	{

		log.info("Customers found with findAll():");
		log.info("-------------------------------");
		for (Product product : repository.findAll()) {
			log.info(product.toString());
		}

		log.info("");

		
		List<Product> produto = repository.findAllByBrand(marca);
		
		model.addAttribute("produto", produto);
		
		return "product-list";
	}

	@PostMapping("/productlist") //ir para product page 
	public String newProduct1(
		@RequestParam(name="pname", required=false) String pname,
		Model model) 
	{

		log.info("Customers found with findAll():");
		log.info("-------------------------------");
		for (Product product : repository.findAll()) {
			log.info(product.toString());
		}

		log.info("");

		List<Product> produto = repository.findOneByName(pname);
		model.addAttribute("produto", produto);
		
		return "product";
	}

}
