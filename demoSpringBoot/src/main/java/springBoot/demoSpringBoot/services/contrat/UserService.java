package springBoot.demoSpringBoot.services.contrat;

 

 
import springBoot.demoSpringBoot.models.User;

public interface UserService {
	
	User findByLogin(String login);
	User save(User user);

}
