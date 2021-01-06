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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="tbl_booking")
public class Booking {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long refence;
	private Date dateBooking ;
	private Date DayOfBooking;
	
	@ManyToOne
    @JoinColumn(name="id_customer", nullable=false)
	private Customer customer;
	
	@OneToMany(mappedBy = "booking")
    Set<BookingDetail> bookingDetails;
	
	
	@OneToOne(mappedBy = "booking", cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn
	private Bill bill;
 
	 

	public Booking() {
		// TODO Auto-generated constructor stub
	}

}
