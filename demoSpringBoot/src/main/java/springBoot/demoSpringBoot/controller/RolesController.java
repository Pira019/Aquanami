package springBoot.demoSpringBoot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springBoot.demoSpringBoot.models.Role;
import springBoot.demoSpringBoot.services.contrat.RoleService;

@Controller 
public class RolesController {
	
	private static String[] nameRole= { "Admin","Customer", "Provider"};
	
	
	@Autowired
	private RoleService roleService;
	  

	public RolesController() {
		// TODO Auto-generated constructor stub
	}
 

	@GetMapping("/role")
	public String newole() {
		
		for (String string : nameRole) {
			roleService.SaveRole(new Role(string));
		}
		return "app/test";
	}
	 
}
