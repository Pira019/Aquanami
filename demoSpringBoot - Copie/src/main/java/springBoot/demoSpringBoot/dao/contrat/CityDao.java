package springBoot.demoSpringBoot.dao.contrat;

import org.springframework.data.jpa.repository.JpaRepository;

import springBoot.demoSpringBoot.models.City;

public interface CityDao extends JpaRepository<City, Long> {
	City findByName(String name);
}
