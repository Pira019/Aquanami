package springBoot.demoSpringBoot.services.contrat;

import springBoot.demoSpringBoot.models.Booking;

public interface BookingService {

	Booking save(Booking booking);
	Booking findById(Long id);
	void  delete(Long id);
	void  update(Long id);
	
	
}
