package springBoot.demoSpringBoot.dao.contrat;

import org.springframework.data.jpa.repository.JpaRepository;

import springBoot.demoSpringBoot.models.CategoryActivity;

public interface CategorieActivityDao extends JpaRepository<CategoryActivity, Long>{
	
	CategoryActivity findByCategoryType(String category);
}
