package springBoot.demoSpringBoot.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name ="tbl_categoryActivities")
public class CategoryActivity {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String categoryType;
	private String description;
	
	@OneToMany(mappedBy="categoryActivity", cascade =CascadeType.ALL )
	private Set<Activity> activities;
	
	public CategoryActivity() {
		// TODO Auto-generated constructor stub
	}

}
