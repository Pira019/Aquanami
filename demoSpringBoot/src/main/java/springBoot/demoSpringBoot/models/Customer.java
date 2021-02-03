package springBoot.demoSpringBoot.models;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity 
public class Customer extends Person {
	
	
	
	@OneToMany(mappedBy="customer", cascade = CascadeType.REMOVE)
	private Set<Booking> bookings;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

}
