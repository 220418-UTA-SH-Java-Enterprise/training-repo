package com.revature.services;

import java.util.List;

import com.revature.models.Shop;

public interface ShopService {
	//create a new candy
	boolean createShop(Shop shop);
	//get candy by id
	Shop getShopById(int id);
	//get all candies
	List<Shop> getAllShops();
	//update a candy
	boolean updateShop(Shop shop);
	//delete a candy
	boolean deleteShop(Shop shop);

}
