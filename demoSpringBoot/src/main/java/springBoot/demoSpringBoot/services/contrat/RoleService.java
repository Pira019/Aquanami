package springBoot.demoSpringBoot.services.contrat;

import springBoot.demoSpringBoot.models.Role;

public interface RoleService {
	
	void SaveRole(Role role);
	Role findByNameRole(String roleName);

}
