package springBoot.demoSpringBoot.services.contrat;
 

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import springBoot.demoSpringBoot.models.Activity;
import springBoot.demoSpringBoot.models.Provider;

public interface ActivityService {
	
	Activity save(Activity activity);
	Activity findById(Long id);
	List<Activity> findByProvider(Provider provider);
	void deletebyId(long id);
	Page<Activity> getPaginatedActivities(Pageable pageable);
	List<Activity> findAll();
	Activity findByActivityName(String activityname);

	
	
	 //Files Strorage //
	  
	  /*public void init();
	  public void save(MultipartFile file);
	  public Resource load(String fileName);
	  public void deleteAll();
	  public Stream<Path> loadAll();*/
}
