package springBoot.demoSpringBoot.dao.contrat;

import org.springframework.data.jpa.repository.JpaRepository;

import springBoot.demoSpringBoot.models.Adress;

public interface AdressDao extends JpaRepository<Adress, Long>{

}
