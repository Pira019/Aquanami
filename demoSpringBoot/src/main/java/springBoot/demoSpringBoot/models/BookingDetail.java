package springBoot.demoSpringBoot.models;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name="tbl_bookingDetails")
public class BookingDetail {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NonNull
	@Column(nullable = false)
	private LocalDateTime startHour ;
	
	@NonNull
	@Column(nullable = false)
	private LocalDateTime endHour;
	
	private String nbrPerson;
	
	@ManyToOne    
    @JoinColumn(name = "booking_id",nullable=false)
    Booking booking;

    @ManyToOne
   // @MapsId("activityId")
    @JoinColumn(name = "activity_id")
    Activity activity;
	
	/*@OneToOne(mappedBy = "bookingDetail")
    private Activity activity;*/
	
	public BookingDetail() {
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
	 * @return the startHour
	 */
	public LocalDateTime getStartHour() {
		return startHour;
	}

	/**
	 * @param startHour the startHour to set
	 */
	public void setStartHour(LocalDateTime startHour) {
		this.startHour = startHour;
	}

	/**
	 * @return the endHour
	 */
	public LocalDateTime getEndHour() {
		return endHour;
	}

	/**
	 * @param endHour the endHour to set
	 */
	public void setEndHour(LocalDateTime endHour) {
		this.endHour = endHour;
	}

	/**
	 * @return the nbrPerson
	 */
	public String getNbrPerson() {
		return nbrPerson;
	}

	/**
	 * @param nbrPerson the nbrPerson to set
	 */
	public void setNbrPerson(String nbrPerson) {
		this.nbrPerson = nbrPerson;
	}

	/**
	 * @return the booking
	 */
	public Booking getBooking() {
		return booking;
	}

	/**
	 * @param booking the booking to set
	 */
	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	/**
	 * @return the activity
	 */
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
