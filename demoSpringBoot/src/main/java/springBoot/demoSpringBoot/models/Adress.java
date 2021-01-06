package springBoot.demoSpringBoot.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
		private String city;
		private String quater;
		private String nameOfPlace;
		private double latitude;
		private double longitude;
		
		@OneToMany(mappedBy="adress", cascade = CascadeType.REMOVE)
		private Set<Activity> activities;
		
		
	public Adress() {
		// TODO Auto-generated constructor stub
	}

}
