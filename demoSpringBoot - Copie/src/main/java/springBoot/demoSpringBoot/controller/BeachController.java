package springBoot.demoSpringBoot.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

 
import javax.servlet.http.HttpServletRequest;
 
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
 

import springBoot.demoSpringBoot.models.Admin;
import springBoot.demoSpringBoot.models.Adress;
import springBoot.demoSpringBoot.models.City;
import springBoot.demoSpringBoot.models.Picture;
import springBoot.demoSpringBoot.models.Plage;
import springBoot.demoSpringBoot.services.contrat.AdminService;
import springBoot.demoSpringBoot.services.contrat.AdressService;
import springBoot.demoSpringBoot.services.contrat.CityService;
import springBoot.demoSpringBoot.services.contrat.PlageService;
 

@Controller
@RequestMapping("/beach")
public class BeachController {

	@Autowired
	PlageService plageService;
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private AdressService adressService;
	
	public BeachController() {
		// TODO Auto-generated constructor stub
	}
	
	 
	@GetMapping("/new")
	public String newBeach(Model model) {
		
		 
		model.addAttribute("userData", new Plage()); 	 
		model.addAttribute("txt", "Créer une plage");
		model.addAttribute("action", "/beach/save");
		model.addAttribute("typeUser", "beach");
		model.addAttribute("cityData", cityService.getAllCities()); 
		 
		return "app/form";
	}
	
	
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("userData") Plage plage, BindingResult result, Model model
			 ) throws IOException{
		
		
		
		if(result.hasErrors()) {
			
			model.addAttribute("userData",plage);
			model.addAttribute("cityData", cityService.getAllCities()); 
			model.addAttribute("txt", "Créer une plage");
			model.addAttribute("action", "/beach/save");
			model.addAttribute("typeUser", "beach");
		 
			return "app/form";
		}
		
		 if (plageService.findByName(plage.getName()) != null) {
			
			model.addAttribute("userData",plage);  
			model.addAttribute("cityData", cityService.getAllCities()); 
			model.addAttribute("txt", "Créer une plage");
			model.addAttribute("action", "/beach/save");
			model.addAttribute("typeUser", "beach");
			model.addAttribute("message", "Cette plage existe deja ! veillez juste ajoutez les activités");
			
			return "app/form";
		} 
		City city =cityService.findByCityName(plage.getAdress().getCity().getName());
		
		if (city == null) {
			
			City city2 = new City();
				city2.setName(plage.getAdress().getCity().getName());
				city= cityService.save(city2);
		}
		
		Adress adress2 = new Adress();
			adress2 = plage.getAdress();
			adress2.setCity(city);
		adressService.save(plage.getAdress());
			
			
		plage.setAdress(adress2);
		plageService.save(plage);
	 
		
		//FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		
		model.addAttribute("message", "Plage enregistré avec success");
		return "redirect:/?success";
		
	}
	
	

}
