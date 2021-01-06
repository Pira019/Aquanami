package springBoot.demoSpringBoot.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springBoot.demoSpringBoot.models.Role;

@RestController
public class RolesController {
	
	private static String name="It done";
	private static AtomicLong atomicLong= new AtomicLong();

	public RolesController() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/op")
	public Role greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Role(atomicLong.incrementAndGet(), String.format(name, name));
	}
}
