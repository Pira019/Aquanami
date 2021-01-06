package springBoot.demoSpringBoot.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name= "tbs_users")
public class User{
	
	@Id @GeneratedValue
	private long id; 
	private String login;
	private String password;
	
	@ManyToOne
    @JoinColumn(name="id_role", nullable=false)
	private Role role;
	

	public User() {
		// TODO Auto-generated constructor stub
	}

}
