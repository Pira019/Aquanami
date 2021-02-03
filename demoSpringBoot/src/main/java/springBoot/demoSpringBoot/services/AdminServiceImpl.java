package springBoot.demoSpringBoot.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import springBoot.demoSpringBoot.dao.contrat.AdminDao;
import springBoot.demoSpringBoot.dao.contrat.RoleDao;
import springBoot.demoSpringBoot.models.Admin;
import springBoot.demoSpringBoot.models.User;
import springBoot.demoSpringBoot.services.contrat.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;
	
 
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	 
	public AdminServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Admin save(Admin admin) {
		 
		 admin.getUser().setPassword(bCryptPasswordEncoder.encode(admin.getUser().getPassword()));
      
		return   adminDao.save(admin);
		
	}

	@Override
	public User findByUser(String userName) {
		// TODO Auto-generated method stub
		return adminDao.findByUser(userName);
	}

	 

	 
	 

}
