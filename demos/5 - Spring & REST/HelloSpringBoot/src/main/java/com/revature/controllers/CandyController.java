package com.revature.controllers;

import static com.revature.util.ClientMessageUtil.CREATION_FAILED;
import static com.revature.util.ClientMessageUtil.CREATION_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.DELETION_FAILED;
import static com.revature.util.ClientMessageUtil.DELETION_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.UPDATE_FAILED;
import static com.revature.util.ClientMessageUtil.UPDATE_SUCCESSFUL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Candy;
import com.revature.models.ClientMessage;
import com.revature.services.CandyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value = "CandyRestController", description = "REST controller related to Candy Entities")
public class CandyController {
	
	@Autowired
	private CandyService cserv;

	 @ApiOperation(value="Find candy by id number", notes="Provide an id to lookup a specific candy from the API", response = Candy.class)
	 @GetMapping(path = "/candy", consumes = {MediaType.APPLICATION_JSON_VALUE}) 
	 public @ResponseBody Candy getById(@RequestParam(value = "id", name = "id") int id) { 
		 return cserv.getCandyById(id); 
	 }
	
	@GetMapping("/candies")
	@ApiOperation(value="Find all candies")
	public @ResponseBody List<Candy> getAll() {
		return cserv.getAllCandies();
	}
	
	@PostMapping("/candy")
	@ApiOperation(value="Update candy info")
	public @ResponseBody ClientMessage createCandy(@RequestBody Candy candy) {
		return cserv.createCandy(candy) ? CREATION_SUCCESSFUL : CREATION_FAILED;
	}
	
	@PutMapping("/candy")
	public @ResponseBody ClientMessage updateCandy(@RequestBody Candy candy) {
		return cserv.updateCandy(candy) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
	}
	
	@DeleteMapping("/candy")
	public @ResponseBody ClientMessage deleteCandy(@RequestBody Candy candy) {
		return cserv.deleteCandy(candy) ? DELETION_SUCCESSFUL : DELETION_FAILED;
	}
	
	
}
