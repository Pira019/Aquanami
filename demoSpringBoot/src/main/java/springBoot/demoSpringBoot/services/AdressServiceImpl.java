package springBoot.demoSpringBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBoot.demoSpringBoot.dao.contrat.AdressDao;
import springBoot.demoSpringBoot.models.Adress;
import springBoot.demoSpringBoot.services.contrat.AdressService;

@Service
public class AdressServiceImpl implements AdressService {

	@Autowired
	private AdressDao adressDao;
	
	public AdressServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Adress save(Adress adress) {
		// TODO Auto-generated method stub
		return adressDao.save(adress);
	}

}
