package springBoot.demoSpringBoot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Getter;
import lombok.Setter;
import springBoot.demoSpringBoot.models.Role;
import springBoot.demoSpringBoot.services.contrat.RoleService;
@Getter
@Setter
@Controller
public class HomeController {

	@Autowired
	RoleService roleService;
	
	public HomeController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/")
	public String index() {
		Role  roles = new Role();
		
		List<Role> role= new ArrayList<Role>();
		roles.setNameRole("Customer");
		role.add(roles);
	 
		
		for (Role role2 : role) {
			
			roleService.SaveRole(role2);
		}
		 
		
		
		return "app/customer/index";
	}
	
	

}
