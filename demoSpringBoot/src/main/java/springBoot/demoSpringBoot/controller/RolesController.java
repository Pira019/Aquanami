package springBoot.demoSpringBoot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springBoot.demoSpringBoot.models.Role;

@RestController 
public class RolesController {
	
	private static String[] name= { "2","2", "25"};
	private List<Role> list=new ArrayList<Role>();
	
	

	public RolesController() {
		// TODO Auto-generated constructor stub
	}
 

	@RequestMapping("/api")
	public List<Role> api(){
		
		 
		list.add(new Role(2,"role2"));
		
		return list;
	}
}
