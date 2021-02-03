package springBoot.demoSpringBoot.services;

 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import springBoot.demoSpringBoot.dao.contrat.ActivityDao;
import springBoot.demoSpringBoot.models.Activity;
import springBoot.demoSpringBoot.models.Provider;
import springBoot.demoSpringBoot.services.contrat.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService {
		
	@Autowired
	private ActivityDao activityDao;
	 
	public ActivityServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Activity save(Activity activity) {
		// TODO Auto-generated method stub
		activity.setDisponibity(true);
		return activityDao.save(activity);
	}

	@Override
	public List<Activity> findByProvider(Provider provider) {
		// TODO Auto-generated method stub
		return activityDao.findByProvider(provider);
	}

	@Override
	public void deletebyId(long id) {
		activityDao.deleteById(id);
	}

	@Override
	public Activity findById(Long id) {
		// TODO Auto-generated method stub
		return activityDao.getOne(id);
	}

	@Override
	public Page<Activity> getPaginatedActivities(Pageable pageable) {
		// TODO Auto-generated method stub
		return activityDao.findAll(pageable);
	}

	@Override
	public List<Activity> findAll() {
		// TODO Auto-generated method stub
		return activityDao.findAll();
	}

	@Override
	public Activity findByActivityName(String activityname) {
		// TODO Auto-generated method stub
		return activityDao.findByActivityName(activityname);
	}

	 
	 
	
	
}
