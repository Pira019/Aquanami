package springBoot.demoSpringBoot.dao.contrat;

  
import org.springframework.data.jpa.repository.JpaRepository;

import springBoot.demoSpringBoot.models.Plage;

public interface PlageDao  extends JpaRepository<Plage, Long>{
		
	Plage findByName(String name);
	 
}
