package springBoot.demoSpringBoot.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name ="tbl_roles")
public class Role  {
	
	
	@Id @GeneratedValue(strategy =GenerationType.IDENTITY)
	private long id;
	private String nameRole;
	
	@OneToMany(mappedBy="role")
	private Set<User> users;

	public Role() {
		// TODO Auto-generated constructor stub
	}

	public Role(long id, String nameRole) {
		super();
		this.id = id;
		this.nameRole = nameRole;
	}
	
	

}
