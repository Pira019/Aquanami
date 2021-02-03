package springBoot.demoSpringBoot.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import springBoot.demoSpringBoot.dao.contrat.CustomerDao;
import springBoot.demoSpringBoot.dao.contrat.ProviderDao;
import springBoot.demoSpringBoot.models.Customer;
import springBoot.demoSpringBoot.models.Provider;
import springBoot.demoSpringBoot.services.contrat.CustomerService;
import springBoot.demoSpringBoot.services.contrat.RoleService;
import springBoot.demoSpringBoot.services.contrat.UserService;
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao; 
	 
	@Autowired
	private BCryptPasswordEncoder  passwordEncoder;
	
	@Autowired
	private UserService  userService;
	
	public CustomerServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Customer save(Customer customer) {
		
		customer.getUser().setActive(true);
		customer.getUser().setPassword(passwordEncoder.encode(customer.getUser().getPassword()));
       
        
		return customerDao.save(customer);
		 
	}

	@Override
	public Customer findByUserLogin(String email) {
		// TODO Auto-generated method stub
		return customerDao.findByUserLogin(email);
	}

}
