package springBoot.demoSpringBoot.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name ="tbl_roles",
uniqueConstraints = {
		@UniqueConstraint(name = "ROLE_UK", columnNames = "Role_Name")
})
public class Role  {
	
	
	@Id @GeneratedValue(strategy =GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "Role_Name", length = 30, nullable = false)
	private String nameRole;
	
	
	@ManyToMany(mappedBy = "roles")
    private Set<User> users;

	public Role(String nameRole) {
		super();
		this.nameRole = nameRole;
	}

	public Role() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the nameRole
	 */
	public String getNameRole() {
		return nameRole;
	}

	/**
	 * @param nameRole the nameRole to set
	 */
	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}

	/**
	 * @return the users
	 */
	public Set<User> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(Set<User> users) {
		this.users = users;
	}

	 

	 
	
	
	
	

}
