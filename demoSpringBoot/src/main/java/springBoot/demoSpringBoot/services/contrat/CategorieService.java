package springBoot.demoSpringBoot.services.contrat;

import java.util.List;

import springBoot.demoSpringBoot.models.CategoryActivity;

public interface CategorieService {
	
	CategoryActivity save(CategoryActivity activity);
	CategoryActivity findByCategoryType(String category);
	List<CategoryActivity> getAllCategories();

}
