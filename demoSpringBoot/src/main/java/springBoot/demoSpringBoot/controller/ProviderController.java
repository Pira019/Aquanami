package springBoot.demoSpringBoot.controller;

import java.security.Principal;
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

import springBoot.demoSpringBoot.models.Activity;
import springBoot.demoSpringBoot.models.Admin;
import springBoot.demoSpringBoot.models.Plage;
import springBoot.demoSpringBoot.models.Provider;
import springBoot.demoSpringBoot.services.contrat.ActivityService;
import springBoot.demoSpringBoot.services.contrat.ProviderService;
import springBoot.demoSpringBoot.services.contrat.RoleService;
import springBoot.demoSpringBoot.services.contrat.UserService;

@Controller
@RequestMapping("/provider")
public class ProviderController {
	
	final String roleName ="Provider";
	
	@Autowired
	ProviderService providerService;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	private ActivityService activityService;
	
 
	public ProviderController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/register")
	public String newProvider(final Model model)
	{
		model.addAttribute("userData", new Provider());
		model.addAttribute("typeUser", "provider");
		model.addAttribute("txt", "Créer un compte");
		model.addAttribute("action", "/provider/register");
		
		return "app/register";
	}
	
	@PostMapping("/register")
	public String save(@Valid @ModelAttribute("userData") Provider provider, BindingResult result, Model model) {
		 
		 
		if(result.hasErrors()) {
			
			model.addAttribute("userData", provider);
			model.addAttribute("typeUser", "provider");
			model.addAttribute("txt", "Créer un compte");
			model.addAttribute("action", "/provider/register");
			
			return "app/register";
		}
		
		if ( provider.getUser().getPasswordConfirm() != provider.getUser().getPassword()) {
			
			model.addAttribute("userData", provider);
			model.addAttribute("typeUser", "provider");
			model.addAttribute("txt", "Créer un compte");
			model.addAttribute("action", "/provider/register");
			model.addAttribute("message", "Mot de passe de confirmation est incorrect");
			
		}

		if (providerService.findByUser(provider.getUser().getLogin()) != null) {
			
			model.addAttribute("userData", provider);
			model.addAttribute("typeUser", "provider");
			model.addAttribute("txt", "Créer un compte");
			model.addAttribute("action", "/provider/register");
			
			model.addAttribute("message", "Ce compte existe deja");
			return "app/register";
		}

		
		 provider.getUser().setRoles(Arrays.asList(roleService.findByNameRole(roleName)));
		
		  providerService.save(provider);
		
		//userRoleService.save(new UserRole(roleService.findByNameRole(roleName), admin2.getUser()));
		
		  
		return "redirect:/login";
		
	}
	
	
	@GetMapping("/activities")
	public String activities(final Model model,Principal principal)
	{
		 
		model.addAttribute("activtyData", activityService.findByProvider(providerService.findByUser(providerService.findByUser(principal.getName()))));
		model.addAttribute("typeUser", "provider");
		model.addAttribute("txt", "Provider activities");
		 
		return "app/details-form";
	}
	
	
	
	 
}
