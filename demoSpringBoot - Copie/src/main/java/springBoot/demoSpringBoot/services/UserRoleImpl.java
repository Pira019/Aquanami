package springBoot.demoSpringBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBoot.demoSpringBoot.dao.contrat.RoleUserDao;
import springBoot.demoSpringBoot.models.UserRole;
import springBoot.demoSpringBoot.services.contrat.UserRoleService;

@Service
public class UserRoleImpl implements UserRoleService {
		
	@Autowired
	private RoleUserDao roleUserDao;
	
	public UserRoleImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(UserRole userRole) {
		roleUserDao.save(userRole);
	}

}
