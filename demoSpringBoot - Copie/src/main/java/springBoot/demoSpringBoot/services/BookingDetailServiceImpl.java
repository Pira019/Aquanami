package springBoot.demoSpringBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBoot.demoSpringBoot.dao.contrat.BookingDetailDao;
import springBoot.demoSpringBoot.models.BookingDetail;
import springBoot.demoSpringBoot.services.contrat.BookingDetailService;

@Service
public class BookingDetailServiceImpl implements BookingDetailService {

	@Autowired
	private BookingDetailDao bookingDetailDao; 
	
	public BookingDetailServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public BookingDetail save(BookingDetail bookingDetail) {
		// TODO Auto-generated method stub
		return bookingDetailDao.save(bookingDetail);
	}

}
