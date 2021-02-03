package springBoot.demoSpringBoot.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import springBoot.demoSpringBoot.dao.contrat.ProviderDao;
import springBoot.demoSpringBoot.models.Admin;
import springBoot.demoSpringBoot.models.Provider;
import springBoot.demoSpringBoot.models.User;
import springBoot.demoSpringBoot.services.contrat.ProviderService;
import springBoot.demoSpringBoot.services.contrat.UserService;

@Service
public class ProviderServiceImpl implements ProviderService {

	@Autowired
	ProviderDao providerDao;
	
	 
	@Autowired
	private BCryptPasswordEncoder  passwordEncoder;
	
	@Autowired
	private UserService  userService;
	
	public ProviderServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Provider save(Provider provider) {
		provider.getUser().setActive(true);
		provider.getUser().setPassword(passwordEncoder.encode(provider.getUser().getPassword()));
		 
        
		return  providerDao.save(provider);
	}

	@Override
	public User findByUser(String userName) {
		// TODO Auto-generated method stub
		return userService.findByLogin(userName);	
		}

	@Override
	public Provider findByUser(User user) {
		// TODO Auto-generated method stub
		return providerDao.findByUser(user);
	}

}
