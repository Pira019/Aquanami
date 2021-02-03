package springBoot.demoSpringBoot.dao.contrat;

import org.springframework.data.jpa.repository.JpaRepository;

import springBoot.demoSpringBoot.models.Admin;
import springBoot.demoSpringBoot.models.User;
 

public interface AdminDao extends JpaRepository<Admin, Long>{
	 User findByUser(String userName); 
}
