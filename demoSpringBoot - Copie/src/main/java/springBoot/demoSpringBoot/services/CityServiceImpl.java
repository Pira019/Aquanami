package springBoot.demoSpringBoot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import springBoot.demoSpringBoot.dao.contrat.CityDao;
import springBoot.demoSpringBoot.models.City;
import springBoot.demoSpringBoot.services.contrat.CityService;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
 private CityDao cityDao;
 
	public CityServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<City> getAllCities() {
		// TODO Auto-generated method stub
		return cityDao.findAll(Sort.by(Sort.Direction.ASC,"name"));
	}

	@Override
	public City save(City city) {
		// TODO Auto-generated method stub
		return cityDao.save(city);
	}

	@Override
	public City findByCityName(String name) {
		// TODO Auto-generated method stub
		return cityDao.findByName(name);
	}

}
