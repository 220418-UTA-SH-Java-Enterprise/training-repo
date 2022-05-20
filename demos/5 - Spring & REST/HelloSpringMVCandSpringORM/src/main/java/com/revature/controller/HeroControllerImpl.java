package com.revature.controller;

import static com.revature.util.ClientMessageUtil.REGISTATION_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.SOMETHING_IS_WRONG;

import org.springframework.http.MediaType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.ClientMessage;
import com.revature.model.Hero;
import com.revature.service.HeroService;

//this will tell Spring MVC that this class can handle HTTP requests
@Controller
//@RequestMapping specifies a URL at which the method is available - binding a function/class to a URL pattern (GET or POST)
@RequestMapping("/api")
public class HeroControllerImpl implements HeroController{
	
	//since this controller relies on the service layer, we need to inject this dependency
	@Autowired
	HeroService heroService;

	/*
	 * GET mapping specifies that if the client sends a get request to this URL, this method will trigger the response
	 * 
	 * URL: http://localhost:8080/HelloSpringMVCandSpringData/api/findAllHeroes
	 * 
	 * ---------------------
	 * 
	 * @ResponseBody specifies what we return to the client (typically in JSON format) -> Java (JSON marshalling objects)
	 */
	@Override
	@GetMapping("/findAllHeroes")
	public @ResponseBody List<Hero> findAllHeroes() {
		// we would have to call the service layer here
		return heroService.getAllHeroes();
	}

	@Override
	@PostMapping(path="/register", consumes= {MediaType.APPLICATION_JSON_VALUE}) //automatically allows us to create new resources through our controller
	//@RequestBody specifies the type of information the method is taking in -> Unmarshalling (taking in JSON object and turning into Java objects)
	public @ResponseBody ClientMessage registerHero(@RequestBody Hero hero) {
		/*
		 * based on whether the insert operation is successful, we will return a specific ClientMessage
		 * when I call the service method.
		 * 
		 * If it is successful, we send a SUCCESS message; if not successful, we send back a message "something went wrong"
		 */
		return heroService.registerHero(hero) ? REGISTATION_SUCCESSFUL : SOMETHING_IS_WRONG;
	}

	@Override
	@GetMapping("/findHero")
	//@RequestParam will extract name from params of the URL for us
	//ex. http://localhost:8080/HelloSpringMVCandSpringData/api/findHero?name=bob
	public @ResponseBody Hero findHero(@RequestParam String name) {
		return heroService.getHero(name); //thanks to Jackson Databind, this will return a JSON object
	}

}
