package springBoot.demoSpringBoot.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name= "tbl_Role_users")
public class UserRole {
	
	@Id @GeneratedValue(strategy =GenerationType.IDENTITY)
	private long id;
	

	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("RoleId")
	 @JoinColumn(name = "Role_Id", nullable = false)
	private Role role;

	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("UserId")
    @JoinColumn(name = "User_Id", nullable = false)    
    private User user;
 

	public UserRole(Role role, User user) {
		super();
		this.role = role;
		this.user = user;
	}


	public UserRole() {
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
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}


	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}


	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}


	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	

}
