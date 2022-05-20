package com.revature.controllers;

import static com.revature.util.ClientMessageUtil.*;

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

import com.revature.models.ClientMessage;
import com.revature.models.Shop;
import com.revature.services.ShopService;

@RestController
@RequestMapping("/api")
public class ShopController {

	@Autowired
	private ShopService sserv;

	@GetMapping(path = "/shop/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody Shop getById(@PathVariable int id) {
		return sserv.getShopById(id);
	}
	
	@GetMapping("/shops")
	public @ResponseBody List<Shop> getAll() {
		return sserv.getAllShops();
	}
	
	@PostMapping("/shop")
	public @ResponseBody ClientMessage createShop(@RequestBody Shop shop) {
		return sserv.createShop(shop) ? CREATION_SUCCESSFUL : CREATION_FAILED;
	}
	
	@PutMapping("/shop")
	public @ResponseBody ClientMessage updateShop(@RequestBody Shop shop) {
		return sserv.updateShop(shop) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
	}
	
	@DeleteMapping("/shop")
	public @ResponseBody ClientMessage deleteShop(@RequestBody Shop shop) {
		return sserv.deleteShop(shop) ? DELETION_SUCCESSFUL : DELETION_FAILED;
	}
}
