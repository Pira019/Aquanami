package springBoot.demoSpringBoot.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name="tbl_bookingDetails")
public class BookingDetail {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Date startHour ;
	private Date endHour;
	private long nbrPerson;
	
	@ManyToOne
    @MapsId("bookingId")
    @JoinColumn(name = "booking_id")
    Booking booking;

    @ManyToOne
    @MapsId("activityId")
    @JoinColumn(name = "activity_id")
    Activity activity;
	
	/*@OneToOne(mappedBy = "bookingDetail")
    private Activity activity;*/
	
	public BookingDetail() {
		// TODO Auto-generated constructor stub
	}

}
