package springBoot.demoSpringBoot.dao.contrat;

import org.springframework.data.jpa.repository.JpaRepository;

import springBoot.demoSpringBoot.models.Provider;
import springBoot.demoSpringBoot.models.User;

public interface ProviderDao extends JpaRepository<Provider, Long> {
	 User findByUserLogin(String userName); 
	 Provider findByUser(User user); 
}
