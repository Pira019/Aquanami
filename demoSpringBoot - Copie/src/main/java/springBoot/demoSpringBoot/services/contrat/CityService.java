package springBoot.demoSpringBoot.services.contrat;

import java.util.List;

import springBoot.demoSpringBoot.models.City;

public interface CityService {
	
	List<City> getAllCities();
	City save(City city);
	City findByCityName(String name);
}
