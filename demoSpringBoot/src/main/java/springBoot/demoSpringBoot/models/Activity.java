package springBoot.demoSpringBoot.models;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
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
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name= "tbl_activities")
public class Activity {
	
	@Id @GeneratedValue(strategy =GenerationType.IDENTITY)
	private long id;
	
	private String activityName;
	private long pricePerHour;
	private Date startDisponibility;
	private Date endDisponibility;
	private boolean disponibity;
	
	
	
	@ManyToOne
    @JoinColumn(name="id_provider", nullable=false)
	private Provider provider;
	
	 
	@ManyToOne
    @JoinColumn(name="id_category", nullable=false)
	private CategoryActivity categoryActivity;
	
	
	@ManyToOne
    @JoinColumn(name="id_adress", nullable=false)
	private Adress adress;
	
	@OneToMany(mappedBy = "activity")
    Set<BookingDetail> bookingDetails;
	
	@OneToMany(mappedBy="activity", cascade = CascadeType.REMOVE)
	private Set<Picture> pictures;
	
	 /*@OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "bookingDetail_id", referencedColumnName = "id")
	    private BookingDetail bookingDetail;*/
	
 
	

	public Activity() {
		// TODO Auto-generated constructor stub
	}

}
