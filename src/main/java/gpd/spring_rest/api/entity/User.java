package gpd.spring_rest.api.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import io.swagger.annotations.Api;

@Entity
@NamedQueries(value = { 
		@NamedQuery(name = "User.findByEmail", query = "select u from User u where u.email =:pEmail"),
		@NamedQuery(name = "User.findAll", query = "select u from User u")
		
		
})
public class User {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String city;
	
	@Column (unique = true)
	private String email;
	
	
	public User () {
		this.id = UUID.randomUUID().toString();
				
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
