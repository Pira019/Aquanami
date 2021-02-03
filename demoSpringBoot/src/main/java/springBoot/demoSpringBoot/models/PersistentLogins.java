package springBoot.demoSpringBoot.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="tbl_PersistentLogins")
public class PersistentLogins {
	
	@Id
	private String series;
	private String userName;
	private String token;
	private Date lastUser;
	;

	public PersistentLogins() {
		// TODO Auto-generated constructor stub
	}

}
