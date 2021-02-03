package springBoot.demoSpringBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springBoot.demoSpringBoot.dao.contrat.BookingDao;
import springBoot.demoSpringBoot.models.Booking;
import springBoot.demoSpringBoot.services.contrat.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingDao bookingDao;
	
	public BookingServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Booking save(Booking booking) {
		// TODO Auto-generated method stub
		return bookingDao.save(booking);
	}

	@Override
	public Booking findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Long id) {
		// TODO Auto-generated method stub

	}

}
