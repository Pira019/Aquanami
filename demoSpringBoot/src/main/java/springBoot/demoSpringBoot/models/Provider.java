package springBoot.demoSpringBoot.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name= "tbl_providers")
public class Provider {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	 	 
	@NotEmpty(message = "Le nom du founisseur ne peut pas être vide")
	@Column(length = 128, nullable = false)
	private String nameProvider;
	
	@Column(length = 128, nullable = false)	 	
	private String licenseNumber; 
	
	@NotEmpty(message = "Le type de fournisseur ne peut pas être vide")
	@Column(length = 128, nullable = false)
	private String typeProvider;
	
	@NotEmpty(message = "Le numèro ne peut pas être vide")
	@Column(length = 128, nullable = false)
	@NotNull
	private String numContact;
	
	@OneToMany(mappedBy="provider", cascade = CascadeType.REMOVE)
	private Set<Activity> activities;
	
	 
	@OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
	 private User user;

	
	public Provider() {
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
	 * @return the nameProvider
	 */
	public String getNameProvider() {
		return nameProvider;
	}


	/**
	 * @param nameProvider the nameProvider to set
	 */
	public void setNameProvider(String nameProvider) {
		this.nameProvider = nameProvider;
	}


	/**
	 * @return the licenseNumber
	 */
	public String getLicenseNumber() {
		return licenseNumber;
	}


	/**
	 * @param licenseNumber the licenseNumber to set
	 */
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}


	/**
	 * @return the typeProvider
	 */
	public String getTypeProvider() {
		return typeProvider;
	}


	/**
	 * @param typeProvider the typeProvider to set
	 */
	public void setTypeProvider(String typeProvider) {
		this.typeProvider = typeProvider;
	}


	/**
	 * @return the numContact
	 */
	public String getNumContact() {
		return numContact;
	}


	/**
	 * @param numContact the numContact to set
	 */
	public void setNumContact(String numContact) {
		this.numContact = numContact;
	}


	/**
	 * @return the activities
	 */
	public Set<Activity> getActivities() {
		return activities;
	}


	/**
	 * @param activities the activities to set
	 */
	public void setActivities(Set<Activity> activities) {
		this.activities = activities;
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
