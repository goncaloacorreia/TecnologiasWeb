package TWork;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.*;
import javax.persistence.OneToMany;


@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String username;
	private String password;
	private String role;

	@OneToMany(mappedBy = "client")
	private List<Order> orders;

	protected Client() {}
	
	public Client(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
		
	}
	
	@Override
	public String toString() {
		return String.format(
				"Client[id=%d, username = '%s', password = '%s', role = '%s']",
				id, username, password, role);
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}


}
