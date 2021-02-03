package springBoot.demoSpringBoot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBoot.demoSpringBoot.dao.contrat.CategorieActivityDao;
import springBoot.demoSpringBoot.models.CategoryActivity;
import springBoot.demoSpringBoot.services.contrat.CategorieService;

@Service
public class CategorieServiceImpl implements CategorieService {

	@Autowired
	private CategorieActivityDao categorieActivityDao;
	
	
	public CategorieServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public CategoryActivity save(CategoryActivity activity) {
		// TODO Auto-generated method stub
		return categorieActivityDao.save(activity);
	}

	@Override
	public CategoryActivity findByCategoryType(String category) {
		// TODO Auto-generated method stub
		return categorieActivityDao.findByCategoryType(category);
	}

	@Override
	public List<CategoryActivity> getAllCategories() {
		// TODO Auto-generated method stub
		return categorieActivityDao.findAll();
	}

}
