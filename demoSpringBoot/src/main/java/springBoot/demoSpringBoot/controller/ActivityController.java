package springBoot.demoSpringBoot.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.service.internal.ProvidedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import springBoot.demoSpringBoot.models.Activity;
import springBoot.demoSpringBoot.models.CategoryActivity;
import springBoot.demoSpringBoot.models.Picture;
import springBoot.demoSpringBoot.models.Plage;
import springBoot.demoSpringBoot.models.Provider;
import springBoot.demoSpringBoot.services.contrat.ActivityService;
import springBoot.demoSpringBoot.services.contrat.CategorieService;
import springBoot.demoSpringBoot.services.contrat.PictureService;
import springBoot.demoSpringBoot.services.contrat.PlageService;
import springBoot.demoSpringBoot.services.contrat.ProviderService;
import springBoot.demoSpringBoot.webUtils.FileUploadUtil;

@Controller
@RequestMapping("/activity")
public class ActivityController {
	
	
	@Autowired
	private PlageService plageService;
	
	@Autowired
	private ActivityService activityService;
	
	@Autowired
	private CategorieService categorieService;
	
	@Autowired
	private ProviderService providerService;
	
	@Autowired
	private PictureService pictureService;
	
	public ActivityController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping(path = {"/","/index"})
	public String detailActivity() {

		return "app/home";
	}
	
	
	@GetMapping("/new")
	public String newActivity(Model model) {
		
		model.addAttribute("userData", new Activity()); 	 
		model.addAttribute("txt", "Créer une activité");
		model.addAttribute("action", "/activity/save");
		model.addAttribute("typeUser", "activity");
		model.addAttribute("plageData", plageService.getAllplages()); 
		model.addAttribute("categoryData", categorieService.getAllCategories()); 
		 
		return "app/form";

	}
	
	@PostMapping("/save")
	public String newActivity(@Valid @ModelAttribute("userData") Activity activity, BindingResult result, Model model,Principal principal,
			@RequestParam("files") MultipartFile[] files) {
		
		String uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/uploads";
		StringBuilder fileNames = new StringBuilder();
		
		if(result.hasErrors()) {
			
			model.addAttribute("userData", activity);
			model.addAttribute("plageData", plageService.getAllplages()); 
			model.addAttribute("categoryData", categorieService.getAllCategories());
			model.addAttribute("txt", "Créer une activité");
			model.addAttribute("action", "/activity/save");
			model.addAttribute("typeUser", "activity");
		 
			return "app/form";
		}
		
		 
		 
		CategoryActivity categoryActivity = categorieService.findByCategoryType(activity.getCategoryActivity().getCategoryType());
		
		if (categoryActivity == null) {
				categoryActivity = categorieService.save(activity.getCategoryActivity());
		}
		activity.setCategoryActivity(categoryActivity);
		activity.setPlage(plageService.findByName(activity.getPlage().getName()));
		
		activity.setProvider(providerService.
				findByUser(providerService
						.findByUser(principal.getName())));
		
		
		
		 List<Picture> pictures2 = new ArrayList();
		 Picture picture=  new Picture();
		 
		 int num=0;
		 
		for (MultipartFile file : files) {
			
			
			 String ext = getFileExtension(file.getOriginalFilename());
			 final String name = getFileName(file.getOriginalFilename());
			
			  
			  Path  fileNameAndPath = Paths.get(uploadDirectory, name +"_"+num+ext);
			  
			  while (Files.exists(fileNameAndPath)) {
				 num++;
				 
				 fileNameAndPath = Paths.get(uploadDirectory, name +"_"+ num+ext);
				
			  	}
			  
			  picture.setPathName(name +"_"+ num+ext);
			  pictures2.add(picture);
			  
			 
			fileNames.append(file.getOriginalFilename()+" ");
				  try { 
					   
					Files.write(fileNameAndPath, file.getBytes());
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				  
				
			 
		  }
		Activity activity2=activityService.save(activity);
		
		for (Picture picture2 : pictures2) {
			picture2.setActivity(activity2);			 
			pictureService.save(picture2);
		}
		  
		 
		  
		model.addAttribute("message", "Activity added successfully");
		 
		return "redirect:/provider/activities?";
		
	}
	
	 
	@GetMapping("/edit/{id}")
	public String editActivity(@PathVariable("id") long id) {
		return "redirect:/";
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteActivity(@PathVariable("id")long id, Principal principal, Model model
			) {
		
		Provider provider= providerService.findByUser(providerService.findByUser(principal.getName()));
		
		if (!activityService.findByProvider(provider).isEmpty()) {
			
			activityService.deletebyId(id);
			 model.addAttribute("message", "Delete successfully");
		}else {
			
			model.addAttribute("message", "Delete error");
			return "redirect:/provider/activities?r=error";
		}
		return "redirect:/provider/activities?r=sucess";
	}
	
	public static String getFileName(String fileName) {
	     return fileName.substring(0, fileName.lastIndexOf('.'));
	}
	
	 
	public static String getFileExtension(final String path) {
	     if (path != null && path.lastIndexOf('.') != -1) {
	         return path.substring(path.lastIndexOf('.'));
	     }
	     return null;
	}
}
