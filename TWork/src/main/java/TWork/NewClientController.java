package TWork;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@Controller
public class NewClientController {

	private static final Logger log = LoggerFactory.getLogger(NewClientController.class);

    @Autowired
    private ClientRepository repository;
    
	@PostMapping("/registo")
	public String newClient(
		@RequestParam(name="username", required=false, defaultValue="World") String username,
		@RequestParam(name="password", required=false, defaultValue="World") String password,
		@RequestParam(name="role", required=false, defaultValue="ROLE_USER") String role,
		Model model) 
			
	{
		String encodedPassword = new BCryptPasswordEncoder().encode(password);

		repository.save(new Client(username, encodedPassword, role));
		
		log.info("Customers found with findAll():");
		log.info("-------------------------------");
		for (Client aClient : repository.findAll()) {
			log.info(aClient.toString());
		}
		log.info("");
		
		model.addAttribute("username", username);
		model.addAttribute("password", encodedPassword);
		model.addAttribute("role", role);
		return "registo-view";
	}
}
