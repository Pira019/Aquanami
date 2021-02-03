package springBoot.demoSpringBoot.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

 
/**
 * checkout for booking
 *
 */
@Entity
@Getter
@Setter
@Table(name = "tbl_bill")
public class Bill {

	@Id @GeneratedValue
	private long id;
	private String typeOfPaiement;
	private Date dateBill;
	
	@OneToOne
    @MapsId
    @JoinColumn(name = "booking_id")
	private Booking booking;
	
	public  Bill() {
		// TODO Auto-generated constructor stub
	}

}
