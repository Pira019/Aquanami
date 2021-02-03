package springBoot.demoSpringBoot.models;

import java.time.LocalDate;
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
	private LocalDate dateBooking ;
	//private Date DayOfBooking;
	
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



	/**
	 * @return the refence
	 */
	public long getRefence() {
		return refence;
	}



	/**
	 * @param refence the refence to set
	 */
	public void setRefence(long refence) {
		this.refence = refence;
	}



	 



	/**
	 * @return the dateBooking
	 */
	public LocalDate getDateBooking() {
		return dateBooking;
	}



	/**
	 * @param dateBooking the dateBooking to set
	 */
	public void setDateBooking(LocalDate dateBooking) {
		this.dateBooking = dateBooking;
	}



	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}



	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	/**
	 * @return the bookingDetails
	 */
	public Set<BookingDetail> getBookingDetails() {
		return bookingDetails;
	}



	/**
	 * @param bookingDetails the bookingDetails to set
	 */
	public void setBookingDetails(Set<BookingDetail> bookingDetails) {
		this.bookingDetails = bookingDetails;
	}



	/**
	 * @return the bill
	 */
	public Bill getBill() {
		return bill;
	}



	/**
	 * @param bill the bill to set
	 */
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	
	

}
