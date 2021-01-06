package springBoot.demoSpringBoot.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="tbl_pictures")
public class Picture {
	@Id @GeneratedValue
	private long id; 
	private String pathName;
	
	@ManyToOne
    @JoinColumn(name="id_activity", nullable=false)
	private Activity activity;
	

	public Picture() {
		// TODO Auto-generated constructor stub
	}

}
