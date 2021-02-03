package springBoot.demoSpringBoot.services;

 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import springBoot.demoSpringBoot.dao.contrat.PlageDao;
import springBoot.demoSpringBoot.models.Plage;
import springBoot.demoSpringBoot.services.contrat.PlageService;

@Service
public class PlageServiceImpl implements PlageService {
		
		@Autowired
		private PlageDao plageDao;
		
	public PlageServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Plage save(Plage plage) {
		// TODO Auto-generated method stub
		return plageDao.save(plage);
	}

	@Override
	public Plage findByName(String name) {
		// TODO Auto-generated method stub
		return plageDao.findByName(name);
	}

	@Override
	public List<Plage> getAllplages() {
		// TODO Auto-generated method stub
		return plageDao.findAll(Sort.by(Sort.Direction.ASC,"name"));
	}

 
	
	

	 

}
