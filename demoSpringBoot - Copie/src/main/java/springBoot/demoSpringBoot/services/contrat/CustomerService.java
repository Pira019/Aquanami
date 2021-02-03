package springBoot.demoSpringBoot.services.contrat;

import springBoot.demoSpringBoot.models.Customer;

public interface CustomerService {
		Customer save(Customer customer);
		Customer findByUserLogin(String email);
}
