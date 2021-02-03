package springBoot.demoSpringBoot.models;

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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name ="tbl_categoryActivities")
public class CategoryActivity {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 128, nullable = false)  
	@NotEmpty(message = "Entrer la catégorie")
	@NotBlank(message = "Catégorie ne peut pas etre vide")
	private String categoryType;
	
	private String description;
	
	@OneToMany(mappedBy="categoryActivity", cascade =CascadeType.ALL )
	private Set<Activity> activities;
	
	public CategoryActivity() {
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
	 * @return the categoryType
	 */
	public String getCategoryType() {
		return categoryType;
	}

	/**
	 * @param categoryType the categoryType to set
	 */
	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
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
	
	

}
