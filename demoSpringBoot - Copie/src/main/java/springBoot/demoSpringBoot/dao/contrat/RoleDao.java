package springBoot.demoSpringBoot.dao.contrat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import springBoot.demoSpringBoot.models.Role;

public interface RoleDao extends JpaRepository<Role, Long> {
	
	Role findByNameRole(String nameRole); 
 

}
