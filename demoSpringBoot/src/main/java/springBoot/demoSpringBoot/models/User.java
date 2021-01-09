package springBoot.demoSpringBoot.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name= "tbs_users",
uniqueConstraints = {  
        @UniqueConstraint(name = "USER_UK", columnNames = "user_Name") })
public class User{
	
	@Id @GeneratedValue
	private long id; 
	
	@Column(name = "user_Name", length = 128, nullable = false)
	private String login;
	
	@Column(length = 128, nullable = false)    
	private String password;
	
	@OneToMany(mappedBy = "user")
    Set<UserRole> userRoles;
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}

}
