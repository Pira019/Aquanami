package springBoot.demoSpringBoot.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import springBoot.demoSpringBoot.dao.UserDaoImpl;
import springBoot.demoSpringBoot.models.Admin;
import springBoot.demoSpringBoot.models.Role;
import springBoot.demoSpringBoot.models.User;
import springBoot.demoSpringBoot.models.UserRole;
import springBoot.demoSpringBoot.services.contrat.AdminService;
import springBoot.demoSpringBoot.services.contrat.RoleService;
import springBoot.demoSpringBoot.services.contrat.UserRoleService;
import springBoot.demoSpringBoot.services.contrat.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	final String roleName ="Admin";
	 
		
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private RoleService roleService;
	
	 
	
	public AdminController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/register")
	public String newAdmin(final Model model) {
		//ModelAndView modelAndView= new ModelAndView("app/login");
		model.addAttribute("userData", new Admin());
		model.addAttribute("typeUser", "admin");
		model.addAttribute("txt", "Créer un compte");
		model.addAttribute("action", "/admin/register");
		
		
		return "app/register";
		
	}
	
	
	@PostMapping("/register")
	public String save(@Valid @ModelAttribute("userData")  Admin admin,BindingResult result, Model model) {
		 
		if(result.hasErrors()) {
			
			model.addAttribute("userData", admin);
			model.addAttribute("typeUser", "customer");
			model.addAttribute("action", "/admin/register");
			model.addAttribute("txt", "Créer un compte");
			
			return "app/register";
		}
		
		if (!admin.getUser().getPassword().equals(admin.getUser().getPasswordConfirm())) {
			
			model.addAttribute("userData", admin);
			model.addAttribute("typeUser", "customer");
			model.addAttribute("action", "/admin/register");
			model.addAttribute("txt", "Créer un compte");
			model.addAttribute("message", "Mot de passe de confirmation est incorrect");
		}
		
		if (adminService.findByUser(admin.getUser().getLogin()) != null) {
			
			model.addAttribute("userData", admin);
			model.addAttribute("typeUser", "customer");
			model.addAttribute("action", "/admin/register");
			model.addAttribute("txt", "Créer un compte");
			model.addAttribute("message", "Ce compte existe deja");
			return "app/register";
		}
		
		 admin.getUser().setRoles(Arrays.asList(roleService.findByNameRole(roleName)));
		
		 
		  adminService.save(admin);
		
		//userRoleService.save(new UserRole(roleService.findByNameRole(roleName), admin2.getUser()));
		
		 
		
		return "redirect:/signin";
		
	}
	

}
