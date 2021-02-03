package springBoot.demoSpringBoot.dao.contrat;

import org.springframework.data.jpa.repository.JpaRepository;

import springBoot.demoSpringBoot.models.Customer;

public interface CustomerDao extends JpaRepository<Customer, Long>{
	Customer findByUserLogin(String email);
}
