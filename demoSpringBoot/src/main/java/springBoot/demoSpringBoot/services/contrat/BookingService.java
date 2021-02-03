package springBoot.demoSpringBoot.services.contrat;

import java.util.List;

import springBoot.demoSpringBoot.models.Booking;
import springBoot.demoSpringBoot.models.Customer;

public interface BookingService {

	Booking save(Booking booking);
	Booking findById(Long id);
	void  delete(Long id);
	void  update(Long id);
	List<Booking> findAllByCustomer(Customer customer);
	
	
}
