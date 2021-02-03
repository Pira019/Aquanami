package springBoot.demoSpringBoot.dao.contrat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import springBoot.demoSpringBoot.models.User;

@Repository
public interface UserDao extends JpaRepository<User, Long>{
	
	User findByLogin(String email);
}
