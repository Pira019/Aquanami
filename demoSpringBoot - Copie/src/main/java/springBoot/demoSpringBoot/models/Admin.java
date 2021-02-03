package springBoot.demoSpringBoot.models;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Admin extends Person {

	 
	private static final long serialVersionUID = 1L;

	public Admin() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return super.getFirstName();
	}

	@Override
	public void setFirstName(String firstName) {
		// TODO Auto-generated method stub
		super.setFirstName(firstName);
	}

	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return super.getLastName();
	}

	@Override
	public void setLastName(String lastName) {
		// TODO Auto-generated method stub
		super.setLastName(lastName);
	}

	@Override
	public String getTelNumber() {
		// TODO Auto-generated method stub
		return super.getTelNumber();
	}

	@Override
	public void setTelNumber(String telNumber) {
		// TODO Auto-generated method stub
		super.setTelNumber(telNumber);
	}

	 
	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}

	@Override
	public void setId(long id) {
		// TODO Auto-generated method stub
		super.setId(id);
	}

	@Override
	public User getUser() {
		// TODO Auto-generated method stub
		return super.getUser();
	}

	@Override
	public void setUser(User user) {
		// TODO Auto-generated method stub
		super.setUser(user);
	}

}
