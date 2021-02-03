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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name ="tbl_adresses")
public class Adress {
		
		@Id @GeneratedValue(strategy =GenerationType.IDENTITY)
		private long id;
		
		private String quater;
		private String nameOfPlace;
		private double latitude;
		private double longitude;
		
	 
		@ManyToOne
	    @JoinColumn(name="id_city", nullable=false)
		private City city;

		@OneToMany(mappedBy="adress", cascade = CascadeType.ALL)
		private Set<Plage> plages;
		
	public Adress() {
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
	 * @return the quater
	 */
	public String getQuater() {
		return quater;
	}


	/**
	 * @param quater the quater to set
	 */
	public void setQuater(String quater) {
		this.quater = quater;
	}


	/**
	 * @return the nameOfPlace
	 */
	public String getNameOfPlace() {
		return nameOfPlace;
	}


	/**
	 * @param nameOfPlace the nameOfPlace to set
	 */
	public void setNameOfPlace(String nameOfPlace) {
		this.nameOfPlace = nameOfPlace;
	}


	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}


	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}


	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	/**
	 * @return the city
	 */
	public City getCity() {
		return city;
	}


	/**
	 * @param city the city to set
	 */
	public void setCity(City city) {
		this.city = city;
	}

}
