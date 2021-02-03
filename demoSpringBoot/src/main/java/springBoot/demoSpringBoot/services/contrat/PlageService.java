package springBoot.demoSpringBoot.services.contrat;

 

 

import java.util.List;

import springBoot.demoSpringBoot.models.Plage;

public interface PlageService {
  Plage save(Plage plage);
  Plage findByName(String name);
  List<Plage> getAllplages ();
  
  
 
  
}
