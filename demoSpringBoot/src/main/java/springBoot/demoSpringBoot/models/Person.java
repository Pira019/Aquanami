package springBoot.demoSpringBoot.models;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Person extends User {
	
	private String firstName;
	private String lastName;
	private String telNumber;
	private String profilPicture;

	public Person() {
		// TODO Auto-generated constructor stub
	}

}
