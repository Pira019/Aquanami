package springBoot.demoSpringBoot.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import lombok.Getter;
import lombok.Setter;
import springBoot.demoSpringBoot.models.Activity;
import springBoot.demoSpringBoot.models.Admin;
import springBoot.demoSpringBoot.models.Provider;
import springBoot.demoSpringBoot.models.Role;
import springBoot.demoSpringBoot.models.User;
import springBoot.demoSpringBoot.services.contrat.ActivityService;
import springBoot.demoSpringBoot.services.contrat.RoleService;
import springBoot.demoSpringBoot.services.contrat.UserService;

@Controller
public class HomeController {

	@Autowired
	private ActivityService activityService;
	
	@Autowired
	private UserService userService;
	
	public HomeController() {
		// TODO Auto-generated constructor stub
	}
	
	 @GetMapping({"/", "/welcome"})
	public ModelAndView index() { 
		 
			
			
		 ModelAndView modelAndView = new ModelAndView("app/customer/index");
		
		 int page =1;
		 
		 PageRequest pageable = PageRequest.of(page - 1, 3);
	
		 Page<Activity> activitiesPage = activityService.getPaginatedActivities(pageable);
		 
		 int totalPages = activitiesPage.getTotalPages();
		 
		 if(totalPages > 0) {
	            List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
	            modelAndView.addObject("pageNumbers", pageNumbers);
	        }
		 
		 modelAndView.addObject("txt", "Aquanami");
		 
		 modelAndView.addObject("activeActivityList", true);
	        modelAndView.addObject("activityList", activitiesPage.getContent());
	        return modelAndView;
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("txt", "login");
		model.addAttribute("userData", new User());
		return "app/login";
	}
	
	
	@GetMapping("/403")
	public String accessDenied(Model model) { 
		
		model.addAttribute("txt", "Vous n'avez pas accès à cette page");
		
		return "app/403";
	}
	
	@GetMapping("/logout")
	public String logout() { 
		return "redirect:/";
	}
	
	
	 @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
	    public String logoutSuccessfulPage(Model model) {
	         
	        return "redirect:/";
	    }
	
	 
	 //Detail activity
	 
	 @GetMapping("/detail/{id}")
		public ModelAndView detailActivity(@PathVariable("id") long id) { 
		  
		 ModelAndView modelAndView = new ModelAndView("app/customer/detailpage");
		 modelAndView.addObject("data",activityService.findById(id));
		 
		 return modelAndView; 
		}
	 
	 
	 @GetMapping(path = {"/activities","/activities/page/{page}"})
		public ModelAndView listActivities(@PathVariable("page") int page) { 
			 
				 
			 ModelAndView modelAndView = new ModelAndView("app/customer/activity");
			 
			 PageRequest pageable = PageRequest.of(page - 1, 6);
		
			 Page<Activity> activitiesPage = activityService.getPaginatedActivities(pageable);
			 
			 int totalPages = activitiesPage.getTotalPages();
			 
			 if(totalPages > 0) {
		            List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
		            modelAndView.addObject("pageNumbers", pageNumbers);
		        }
			 
			 modelAndView.addObject("txt", "Activities");
			 
			 modelAndView.addObject("activeActivityList", true);
		        modelAndView.addObject("activityList", activitiesPage.getContent());
		        return modelAndView;
		}
	
	 @GetMapping({"/detail/about"})
		public ModelAndView about() { 
			 
				
				
			 ModelAndView modelAndView = new ModelAndView("app/details-form2");
			
			 int page =1;
			 
			 PageRequest pageable = PageRequest.of(page - 1, 3);
		
			 Page<Activity> activitiesPage = activityService.getPaginatedActivities(pageable);
			 
			 int totalPages = activitiesPage.getTotalPages();
			 
			 if(totalPages > 0) {
		            List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
		            modelAndView.addObject("pageNumbers", pageNumbers);
		        }
			 
			 modelAndView.addObject("txt", "About Us");
			 modelAndView.addObject("typeData", "about"); 
			 
			 modelAndView.addObject("activeActivityList", true);
		        modelAndView.addObject("activityList", activitiesPage.getContent());
		        return modelAndView;
		}
	 
	 @GetMapping({"userInfo"})
		public ModelAndView userInfo(Principal principal) { 
			 
				
				
			 ModelAndView modelAndView = new ModelAndView("app/details-form2");
			 
			 modelAndView.addObject("txt", "Profil user");
			 modelAndView.addObject("typeData", "profil");
			 modelAndView.addObject("userData", userService.findByLogin(principal.getName()));
			 
			 
		        return modelAndView;
		}


}
