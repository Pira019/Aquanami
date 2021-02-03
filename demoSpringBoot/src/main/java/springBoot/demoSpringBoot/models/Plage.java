package springBoot.demoSpringBoot.models;

import java.beans.Transient;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="tbl_plages",
uniqueConstraints = {  
        @UniqueConstraint(name = "USER_UK", columnNames = "name") }) 
public class Plage {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty(message = "Entrer le nom de la plage")
	@NotBlank(message = "Entrer le nom de la plage")
	@Column( length = 128, nullable = false) 
	private String name;;
	
	@OneToMany(mappedBy="plage", cascade = CascadeType.REMOVE)
	private Set<Activity> activities;
	 
	
	/*@OneToMany(mappedBy="plage", cascade = CascadeType.REMOVE)
	private Set<Picture> pictures;*/
	
	@ManyToOne
    @JoinColumn(name="id_adress", nullable=false)
	private Adress adress;

	public Plage() {
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the adress
	 */
	public Adress getAdress() {
		return adress;
	}

	/**
	 * @param adress the adress to set
	 */
	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	 
}
