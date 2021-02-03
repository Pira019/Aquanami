package springBoot.demoSpringBoot.services.contrat;

import springBoot.demoSpringBoot.models.Provider;
import springBoot.demoSpringBoot.models.User;

public interface ProviderService {
	
	Provider save(Provider provider);
	 User findByUser(String userName); 
	 Provider findByUser(User user); 
}
