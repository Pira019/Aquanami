package springBoot.demoSpringBoot.dao.contrat;

 
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import springBoot.demoSpringBoot.models.Activity;
import springBoot.demoSpringBoot.models.Provider;

public interface ActivityDao extends JpaRepository<Activity, Long>  {
  //Activity findByProviderActivities(Activity activity);
	
	List<Activity> findByProvider(Provider provider);
	Page<Activity> findAll(Pageable pageable);
	Activity findByActivityName(String activityname);
	 
	
}
