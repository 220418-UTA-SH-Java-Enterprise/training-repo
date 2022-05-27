package com.revature.controller;

import static com.revature.util.ClientMessageUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.ClientMessage;
import com.revature.model.JwtRequest;
import com.revature.model.JwtResponse;
import com.revature.model.Trainer;
import com.revature.model.UserValidation;
import com.revature.security.JwtTokenUtil;
import com.revature.security.JwtUserDetailsService;
import com.revature.service.TrainerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/trainer")
@CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500"})
@Api(value = "TrainerRestController", description = "REST controller related to Trainer Entities")
public class TrainerController {
	
	@Autowired
	private TrainerService trainerService;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
	@SuppressWarnings({ "unchecked" })
	public String getClaimsValueFromToken(String token) throws Exception {
		System.out.println(token);
		Map<String,String> result =
		        new ObjectMapper().readValue(token, HashMap.class);
		String rawToken = "";
		for (String value : result.values()) {
		    System.out.println("Value = " + value);
		    rawToken = value;
		}
        String username = jwtTokenUtil.getUsernameFromToken(rawToken);
        System.out.println(username);
        return username;
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	
	@RequestMapping(value = "/verify", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> verifyToken(@RequestBody String jwtString) throws Exception {
		ObjectMapper om = new ObjectMapper();
		String username = getClaimsValueFromToken(om.convertValue(jwtString, String.class));
		return ResponseEntity.ok(new UserValidation(username));
	}
	
	@ApiOperation(value="Find trainer by id number", notes="Provide an id to lookup a specific trainer from the API", response = Trainer.class)
	@GetMapping(path = "/id-lookup")
	public @ResponseBody Trainer getById(@RequestParam int id) {
		return trainerService.getTrainerById(id);
	}
	
	@ApiOperation(value="Find trainer by username", notes="Provide an username to lookup a specific trainer from the API", response = Trainer.class)
	@GetMapping(path = "/username-lookup")
	public @ResponseBody Trainer getByUsername(@RequestParam String username) {
		return trainerService.getTrainerByUsername(username);
	}
	
	@ApiOperation(value="Get a list of all trainers")
	@GetMapping("/all")
	public @ResponseBody List<Trainer> getAll() {
		return trainerService.getAllTrainers();
	}
	
	@ApiOperation(value="Create a new trainer entity for registration to the API")
	@PostMapping("/register")
	public @ResponseBody ClientMessage createTrainer(@RequestBody Trainer trainer) {
		return trainerService.registerTrainer(trainer) ? REGISTRATION_SUCCESSFUL : REGISTRATION_FAILED;
	}
	
	@ApiOperation(value="Update details to an existing trainer")
	@PutMapping("/")
	public @ResponseBody ClientMessage updateTrainer(@RequestBody Trainer trainer) {
		return trainerService.updateTrainer(trainer) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
	}
	
	@ApiOperation(value="Remove an existing trainer")
	@DeleteMapping("/")
	public @ResponseBody ClientMessage deleteTrainer(@RequestBody Trainer trainer) {
		return trainerService.deleteTrainer(trainer) ? DELETION_SUCCESSFUL : DELETION_FAILED;
	}
}
