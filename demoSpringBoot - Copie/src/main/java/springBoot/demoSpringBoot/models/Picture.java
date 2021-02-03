package springBoot.demoSpringBoot.models;

import javax.persistence.Entity;
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
@Table(name="tbl_pictures")
public class Picture {
	
	@Id @GeneratedValue(strategy =GenerationType.IDENTITY)
	private long id; 
	private String pathName;
	 
	/*@ManyToOne
    @JoinColumn(name="id_plage", nullable=false)
	private Plage plage;*/
	
	  @ManyToOne	    
	    @JoinColumn(name = "activity_id")
	    Activity activity;
	
	public Picture() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Picture(String pathName) {
		super();
		this.pathName = pathName;
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
	 * @return the pathName
	 */
	public String getPathName() {
		return pathName;
	}

	/**
	 * @param pathName the pathName to set
	 */
	public void setPathName(String pathName) {
		this.pathName = pathName;
	}

	 
	public Activity getActivity() {
		return activity;
	}

	/**
	 * @param activity the activity to set
	 */
	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	 
}
