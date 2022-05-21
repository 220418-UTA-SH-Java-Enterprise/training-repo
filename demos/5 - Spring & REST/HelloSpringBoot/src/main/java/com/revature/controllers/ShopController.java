package com.revature.controllers;

import static com.revature.util.ClientMessageUtil.*;

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

import com.revature.models.ClientMessage;
import com.revature.models.Shop;
import com.revature.services.ShopService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value = "ShopRestController", description = "REST controller related to Shop Entities")
public class ShopController {

	@Autowired
	private ShopService sserv;

	@ApiOperation(value="Find shop by id number", notes="Provide an id to lookup a specific shop from the API", response = Shop.class)
	@GetMapping(path = "/shop", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody Shop getById(@RequestParam int id) {
		return sserv.getShopById(id);
	}
	
	@ApiOperation(value="Get a list of all shops")
	@GetMapping("/shops")
	public @ResponseBody List<Shop> getAll() {
		return sserv.getAllShops();
	}
	
	@ApiOperation(value="Create a new shop entity")
	@PostMapping("/shop")
	public @ResponseBody ClientMessage createShop(@RequestBody Shop shop) {
		return sserv.createShop(shop) ? CREATION_SUCCESSFUL : CREATION_FAILED;
	}
	
	@ApiOperation(value="Update details to an existing shop")
	@PutMapping("/shop")
	public @ResponseBody ClientMessage updateShop(@RequestBody Shop shop) {
		return sserv.updateShop(shop) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
	}
	
	@ApiOperation(value="Remove an existing shop")
	@DeleteMapping("/shop")
	public @ResponseBody ClientMessage deleteShop(@RequestBody Shop shop) {
		return sserv.deleteShop(shop) ? DELETION_SUCCESSFUL : DELETION_FAILED;
	}
}
