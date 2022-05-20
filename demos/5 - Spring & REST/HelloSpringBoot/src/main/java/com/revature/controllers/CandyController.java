package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Candy;
import com.revature.models.ClientMessage;
import static com.revature.util.ClientMessageUtil.*;
import com.revature.services.CandyService;

@RestController
@RequestMapping("/api")
public class CandyController {
	
	@Autowired
	private CandyService cserv;

	@GetMapping(path = "/candy/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody Candy getById(@PathVariable int id) {
		return cserv.getCandyById(id);
	}
	
	@GetMapping("/candies")
	public @ResponseBody List<Candy> getAll() {
		return cserv.getAllCandies();
	}
	
	@PostMapping("/")
	public @ResponseBody ClientMessage createCandy(@RequestBody Candy candy) {
		return cserv.createCandy(candy) ? CREATION_SUCCESSFUL : CREATION_FAILED;
	}
	
	@PutMapping("/")
	public @ResponseBody ClientMessage updateCandy(@RequestBody Candy candy) {
		return cserv.updateCandy(candy) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
	}
	
	@DeleteMapping("/")
	public @ResponseBody ClientMessage deleteCandy(@RequestBody Candy candy) {
		return cserv.deleteCandy(candy) ? DELETION_SUCCESSFUL : DELETION_FAILED;
	}
}