package springBoot.demoSpringBoot.dao.contrat;

import org.springframework.data.jpa.repository.JpaRepository;

import springBoot.demoSpringBoot.models.Booking;

public interface BookingDao extends JpaRepository<Booking, Long> {

}
