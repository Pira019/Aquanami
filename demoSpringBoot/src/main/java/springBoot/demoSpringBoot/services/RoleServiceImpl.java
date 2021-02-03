package springBoot.demoSpringBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBoot.demoSpringBoot.dao.contrat.RoleDao; 
import springBoot.demoSpringBoot.models.Role;
import springBoot.demoSpringBoot.services.contrat.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

		@Autowired
		RoleDao dao;
		
	public RoleServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void SaveRole(Role role) { 
		 dao.save(role);
		
	}

	@Override
	public Role findByNameRole(String roleName) {
		
		return dao.findByNameRole(roleName);
	}

}
