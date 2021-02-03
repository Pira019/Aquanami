package springBoot.demoSpringBoot.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import springBoot.demoSpringBoot.models.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import springBoot.demoSpringBoot.services.contrat.ActivityService;
import springBoot.demoSpringBoot.services.contrat.BookingDetailService;
import springBoot.demoSpringBoot.services.contrat.BookingService;
import springBoot.demoSpringBoot.services.contrat.CityService;
import springBoot.demoSpringBoot.services.contrat.CustomerService;
import springBoot.demoSpringBoot.services.contrat.PlageService;

@Controller
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private BookingDetailService bookingDetailService;
	
	@Autowired
	private CityService CityService;
	
	@Autowired
	private CustomerService customService;
	
	@Autowired
	private PlageService plageService;
	
	@Autowired
	private ActivityService activityService;
	
	 @GetMapping("/")
	  public ModelAndView index(){
		 ModelAndView modelAndView = new ModelAndView("app/customer/booking");
	     
		 modelAndView.addObject("cityData", CityService.getAllCities());
		 modelAndView.addObject("plageData", plageService.getAllplages());
		 modelAndView.addObject("activities", activityService.findAll());
		 modelAndView.addObject("bookingData", new BookingDetail() );
		 modelAndView.addObject("txt", "Booking now");
		 
		 modelAndView.addObject("selectedActivityData",null);
		 
		 return  modelAndView;
	    }
	 
    @GetMapping("/new/{id}")
    public ModelAndView newBooking(@PathVariable("id") long id){
    	
    	ModelAndView modelAndView = new ModelAndView("app/customer/booking");
	     
		 modelAndView.addObject("cityData", CityService.getAllCities());
		 modelAndView.addObject("plageData", plageService.getAllplages());
		 modelAndView.addObject("activities", activityService.findAll());
		 modelAndView.addObject("bookingData", new BookingDetail() );
		 modelAndView.addObject("txt", "Booking now");
		 
		 modelAndView.addObject("selectedActivityData",activityService.findById(id));
		  
		 
		 return  modelAndView;
    }
    
    @PostMapping("/save")
	public ModelAndView save(@Valid @ModelAttribute("userData") BookingDetail bookingDetail, BindingResult result, Model model,Principal principal) {
    	
    	ModelAndView modelAndView = new ModelAndView("app/customer/booking");
  	     
   	/*if(result.hasErrors()) {
    	
   		 modelAndView.addObject("cityData", CityService.getAllCities());
   		 modelAndView.addObject("plageData", plageService.getAllplages());
   		 modelAndView.addObject("activities", activityService.findAll());
   		 modelAndView.addObject("bookingData", bookingDetail);
   		 modelAndView.addObject("txt", "Booking now");
   		 
   		return modelAndView;
    	}*/
    	
    	Booking booking = new Booking();
    	booking.setDateBooking(LocalDateTime.now());
    	booking.setCustomer(customService.findByUserLogin(principal.getName()));    	
    	
    	Booking booking2 = bookingService.save(booking);
    	
    	
    	Activity activity =activityService.findByActivityName(bookingDetail.getActivity().getActivityName());
    	
    	 
    	bookingDetail.setActivity(activity);
    	bookingDetail.setBooking(booking2);
    	
    	bookingDetailService.save(bookingDetail);
    	
    	modelAndView.setViewName("redirect:/");
    	
    	return modelAndView;
    	
    }
    
    
    @GetMapping("/user")
    public ModelAndView BookingUser(Principal principal){
    	
    	ModelAndView modelAndView = new ModelAndView("app/details-form2");
	     
		 modelAndView.addObject("userData", bookingService.findAllByCustomer(customService.findByUserLogin(principal.getName()))); 
		 modelAndView.addObject("typeData", "bookingUser"); 
		 modelAndView.addObject("txt", "My booking(s)");
		 
		 return  modelAndView;
    }
    
    @GetMapping("/delete/{id}")
    public String delete (@PathVariable("id")long id, Model model){
    	
    	
    	bookingService.delete(id);
    	model.addAttribute("msg", "delete successfully");
		 
		 return  "app/details-form2";
    }
}
