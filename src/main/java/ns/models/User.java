package ns.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class User {

	@Id
	private UUID id;

	private String firstName;

	private String lastName;

	private String username;

	private String password;

	private String email;

	public User() {
		this.id = UUID.randomUUID();
	}

	public User(String firstname, String lastname, String username, String password, String email) {
		this();
		this.firstName = firstname;
		this.lastName = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public User(String id, String firstname, String lastname, String username, String password, String email) {
		this(firstname, lastname, username, password, email);
		if (id != null) {
			this.id = UUID.fromString(id);
		}
		this.firstName = firstname;
		this.lastName = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public UUID getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}