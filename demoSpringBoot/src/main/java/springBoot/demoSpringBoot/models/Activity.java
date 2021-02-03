package springBoot.demoSpringBoot.models;


 
 
 

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name= "tbl_activities")
public class Activity {
	
	@Id @GeneratedValue(strategy =GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty(message = "Entrer le nom de l'activité")
	@NotBlank(message = "Entrer le nom de l'activité")
	@Column(nullable = false) 
	private String activityName;
	
	
	private long pricePerHour;
	
	 
	 
	@Column(nullable = false) 
	@NotEmpty(message = "Entrer l'heure du debut")
	@NotBlank(message = "Entrer l'heure de la debut")
	private String startDisponibility;
	 
	 
	@Column(nullable = false) 
	@NotBlank(message = "Entrer l'heure de la fin")
	private String endDisponibility;
	
	
	@Column(columnDefinition = "boolean default true") 	
	private boolean disponibity;
	
	private String description;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="id_provider", nullable=false)
	private Provider provider;
	
	
	@ManyToOne
    @JoinColumn(name="id_plage", nullable=false)
	private Plage plage;
	
	 
	@ManyToOne
    @JoinColumn(name="id_category", nullable=false)
	private CategoryActivity categoryActivity;
	
	@OneToMany(mappedBy="activity", cascade = CascadeType.ALL)
	private Set<Picture> pictures;
	 
	 
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
	 * @return the activityName
	 */
	public String getActivityName() {
		return activityName;
	}

	/**
	 * @param activityName the activityName to set
	 */
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	/**
	 * @return the pricePerHour
	 */
	public long getPricePerHour() {
		return pricePerHour;
	}

	/**
	 * @param pricePerHour the pricePerHour to set
	 */
	public void setPricePerHour(long pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

	/**
	 * @return the startDisponibility
	 */
	public String getStartDisponibility() {
		return startDisponibility;
	}

	/**
	 * @param startDisponibility the startDisponibility to set
	 */
	public void setStartDisponibility(String startDisponibility) {
		this.startDisponibility = startDisponibility;
	}

	/**
	 * @return the endDisponibility
	 */
	public String getEndDisponibility() {
		return endDisponibility;
	}

	/**
	 * @param endDisponibility the endDisponibility to set
	 */
	public void setEndDisponibility(String endDisponibility) {
		this.endDisponibility = endDisponibility;
	}

	/**
	 * @return the disponibity
	 */
	public boolean isDisponibity() {
		return disponibity;
	}

	/**
	 * @param disponibity the disponibity to set
	 */
	public void setDisponibity(boolean disponibity) {
		this.disponibity = disponibity;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * @return the plage
	 */
	public Plage getPlage() {
		return plage;
	}

	/**
	 * @param plage the plage to set
	 */
	public void setPlage(Plage plage) {
		this.plage = plage;
	}

	/**
	 * @return the categoryActivity
	 */
	public CategoryActivity getCategoryActivity() {
		return categoryActivity;
	}

	/**
	 * @param categoryActivity the categoryActivity to set
	 */
	public void setCategoryActivity(CategoryActivity categoryActivity) {
		this.categoryActivity = categoryActivity;
	}

	/**
	 * @return the pictures
	 */
	public Set<Picture> getPictures() {
		return pictures;
	}

	/**
	 * @param pictures the pictures to set
	 */
	public void setPictures(Set<Picture> pictures) {
		this.pictures = pictures;
	}

	 

}
