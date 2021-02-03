package springBoot.demoSpringBoot.dao.contrat;

import org.springframework.data.jpa.repository.JpaRepository;

import springBoot.demoSpringBoot.models.UserRole;

public interface RoleUserDao extends JpaRepository<UserRole, Long>{
		
}
