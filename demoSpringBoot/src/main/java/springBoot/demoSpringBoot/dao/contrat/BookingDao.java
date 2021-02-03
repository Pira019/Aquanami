package springBoot.demoSpringBoot.dao.contrat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import springBoot.demoSpringBoot.models.Booking;
import springBoot.demoSpringBoot.models.Customer;

public interface BookingDao extends JpaRepository<Booking, Long> {
	List<Booking> findAllByCustomerOrderByRefenceDesc(Customer customer);
}
