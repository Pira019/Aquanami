package springBoot.demoSpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/activity")
public class ActivityController {

	public ActivityController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping(path = {"/","/index"})
	public String detailActivity() {

		return "app/home";
	}
	
	
	@PostMapping("new")
	public String newActivity() {

		return "app/home";
	}
	
	@PostMapping("edit")
	public String editActivity() {
		return "app/home";
	}
	
	@PostMapping("delete")
	public String deleteActivity() {
		return "app/home";
	}

}
