package com.revature.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.*;

import com.revature.daos.PlayerDao;
import com.revature.model.Player;

@Service
public class PlayerServiceImpl implements PlayerService{

	private static Logger log = Logger.getLogger(PlayerServiceImpl.class);
	private PlayerDao playerDao;
	
	//here I will use the AutoWired annotation to implement constructor injection
	//autowired takes care of dependencies for this instance for us 
	//(giving control of instantation over to Spring IOC)
	
	@Autowired
	public PlayerServiceImpl(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}
	
	@Override
	public List<Player> getAllPlayers() {
		//implement this logic using Reflections and generics
		//Reflections API is used to examine or modify the behavior of methods/classes/interfaces at runtime
		Class<?> playerService = PlayerServiceImpl.class; //this using generics
		Method[] methods = playerService.getMethods(); //this will show all methods with our PlayerServiceImpl class at runtime
		
		log.info(String.format("%s -> service call to get list of players...", methods[0].getName()));
		
		return playerDao.getAll();
	}

}
