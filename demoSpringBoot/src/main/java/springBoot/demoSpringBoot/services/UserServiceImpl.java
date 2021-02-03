package springBoot.demoSpringBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import springBoot.demoSpringBoot.dao.contrat.UserDao;
import springBoot.demoSpringBoot.models.User;
import springBoot.demoSpringBoot.services.contrat.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	 

	@Override
	public User findByLogin(String login) {
		// TODO Auto-generated method stub
		return userDao.findByLogin(login);
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userDao.save(user);
	}

}
