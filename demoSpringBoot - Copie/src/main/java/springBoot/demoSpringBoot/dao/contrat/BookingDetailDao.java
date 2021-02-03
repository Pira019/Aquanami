package springBoot.demoSpringBoot.dao.contrat;

import org.springframework.data.jpa.repository.JpaRepository;

import springBoot.demoSpringBoot.models.BookingDetail;

public interface BookingDetailDao extends JpaRepository<BookingDetail, Long>{

}
