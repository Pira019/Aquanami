package springBoot.demoSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import springBoot.demoSpringBoot.models.City;
import springBoot.demoSpringBoot.services.contrat.CityService;

@Controller
public class CityController {

	String[] cities = {"AGADIR","BENI MELLAL","BERKANNE","CASABLANCA"
			,"ELJADIDA","FES","INEZGANE","KENITRA","KHEMISSET","KHENIFRA","SETTAT",
			"KHOURIBGA","LAAYOUNE","MARRAKECH","MEKNES","MOHAMMADIA","NADOR","OUJDA",
			"RABAT","SAFI","SALE","SIDI KACEM","TANGER","TAZA","TEMARA","TETOUAN","AL HOCEIMA",
			"BERRECHID","ERRACHIDA","ESSAOUIRA","OUARZAZATE","OUEZANE","SEFROU","TIFLET" };
	
	@Autowired
	CityService cityService;
	
	@GetMapping("/citysave")
	public String city() {
			
		for (String string : cities) {
			
			if (cityService.findByCityName(string) == null) {
				City city= new City();
				city.setName(string);
					cityService.save(city);
			}
		}
		return "redirect:/";
	}
	public CityController() {
		// TODO Auto-generated constructor stub
	}

}
