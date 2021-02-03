package springBoot.demoSpringBoot.services.contrat;

import springBoot.demoSpringBoot.models.Admin;
import springBoot.demoSpringBoot.models.User;

public interface AdminService {
		Admin save(Admin admin);
		 User findByUser(String userName); 
		 
}
