package springBoot.demoSpringBoot.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name= "tbs_providers")
public class Provider extends User {
	
	private String nameProvider;
	private String licenseNumber;
	private String typeProvider;
	private String numContact;
	
	@OneToMany(mappedBy="provider", cascade = CascadeType.REMOVE)
	private Set<Activity> activities;
	
	public Provider() {
		// TODO Auto-generated constructor stub
	}

}
