package springBoot.demoSpringBoot.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name ="tbl_cities")
public class City {
	
	@Id @GeneratedValue(strategy =GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty(message = "Entrer le nom de la ville")
	@NotBlank(message = "Entrer le nom de la ville")
	@Column(name = "city_name",length = 128, nullable = false)  
	private String name;
	
	 
	@OneToMany(mappedBy="city", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<Adress> adresses;


	public City() {
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
	 * @return the adresses
	 */
	public Set<Adress> getAdresses() {
		return adresses;
	}


	/**
	 * @param adresses the adresses to set
	 */
	public void setAdresses(Set<Adress> adresses) {
		this.adresses = adresses;
	}


	 


	 

}
