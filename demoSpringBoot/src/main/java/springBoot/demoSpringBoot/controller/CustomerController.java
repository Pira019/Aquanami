package springBoot.demoSpringBoot.controller;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import springBoot.demoSpringBoot.models.Admin;
import springBoot.demoSpringBoot.models.Customer;
import springBoot.demoSpringBoot.services.contrat.CustomerService;
import springBoot.demoSpringBoot.services.contrat.RoleService;
import springBoot.demoSpringBoot.services.contrat.UserService;
 

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	final String roleName ="Customer";
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;
	
	public CustomerController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/register")
	public String newCustomer(final Model model)
	{
		model.addAttribute("userData", new Customer());
		model.addAttribute("typeUser", "customer");
		model.addAttribute("txt", "Créer un compte");
		model.addAttribute("action", "/customer/register");
		
		return "app/register";
	}
	
	@PostMapping("/register")
	public String save(@Valid @ModelAttribute("userData") Customer customer, BindingResult result, Model model) {
		 
		 
		if(result.hasErrors()) {
			
			model.addAttribute("userData", customer);
			model.addAttribute("typeUser", "customer");
			model.addAttribute("action", "/customer/register");
			model.addAttribute("txt", "Créer un compte");
			
			return "app/register";
		}
		
		if (customer.getUser().getPasswordConfirm() != customer.getUser().getPasswordConfirm()) {
			
			model.addAttribute("userData", customer);
			model.addAttribute("typeUser", "customer");
			model.addAttribute("action", "/customer/register");
			model.addAttribute("txt", "Créer un compte");
			model.addAttribute("message", "Mot de passe de confirmation incorrect ! ");
			
			return "app/register";
		}
	 
		
		if (userService.findByLogin(customer.getUser().getLogin()) != null) {
			
			model.addAttribute("userData", customer);
			model.addAttribute("typeUser", "customer");
			model.addAttribute("action", "/customer/register");
			model.addAttribute("txt", "Créer un compte");
			model.addAttribute("message", "Ce compte existe deja");
			return "app/register";
		}

		
		customer.getUser().setRoles(Arrays.asList(roleService.findByNameRole(roleName)));
		
		  customerService.save(customer);
		 
		return "redirect:/login";
		
	}

}
