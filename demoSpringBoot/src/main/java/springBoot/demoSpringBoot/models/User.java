package springBoot.demoSpringBoot.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name= "tbl_users",
uniqueConstraints = {  
        @UniqueConstraint(name = "USER_UK", columnNames = "user_Name") })
public class  User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy =GenerationType.AUTO)
	private long id; 
	
	//user_name = email
	
	@Column(name = "user_Name", length = 128, nullable = false)
	@Email(message = "Veuillez fournir un email valide")
	@NotEmpty(message = "Le champ e-mail ne peut pas être vide") 
	private String login;
	
	@Column(length = 128, nullable = false)  
	@NotEmpty(message = "Entrer votre le password")
	@NotBlank(message = "Entrer un password")	
	private String password;
	
	@Transient
	private String passwordConfirm;
	
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	/**
	 * @return the passwordConfirm
	 */
	public String getPasswordConfirm() {
		return passwordConfirm;
	}



	/**
	 * @param passwordConfirm the passwordConfirm to set
	 */
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}



	@Column(columnDefinition = "boolean default true") 	 
	private boolean active;
	
	 
	 @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
	    @PrimaryKeyJoinColumn
	    private Person person;
	 
	 @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
	    @PrimaryKeyJoinColumn
	    private Provider provider;
		
	    
	
	@ManyToMany 
    @JoinTable( 
        name = "tbl_role_users", 
        joinColumns = @JoinColumn(
          name = "user_id", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(
          name = "role_id", referencedColumnName = "id")) 
    private Collection<Role> roles;
	
	
	
	public User() {
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
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}



	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}



	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}



	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}



	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}



	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}



	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}



	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}



	/**
	 * @return the provider
	 */
	public Provider getProvider() {
		return provider;
	}



	/**
	 * @param provider the provider to set
	 */
	public void setProvider(Provider provider) {
		this.provider = provider;
	}



	/**
	 * @return the roles
	 */
	public Collection<Role> getRoles() {
		return roles;
	}



	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}



	 

	 


 


}