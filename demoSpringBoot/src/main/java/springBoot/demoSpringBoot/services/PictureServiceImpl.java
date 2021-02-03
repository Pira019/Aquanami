package springBoot.demoSpringBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBoot.demoSpringBoot.dao.contrat.PictureDao;
import springBoot.demoSpringBoot.models.Picture;
import springBoot.demoSpringBoot.services.contrat.PictureService;

@Service
public class PictureServiceImpl implements PictureService {

	@Autowired
	private PictureDao pictureDao;
	
	public PictureServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Picture save(Picture picture) {
		// TODO Auto-generated method stub
		return pictureDao.save(picture);
	}

}
