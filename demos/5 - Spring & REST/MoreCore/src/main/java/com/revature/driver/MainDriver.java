package com.revature.driver;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.model.Player;
import com.revature.services.PlayerService;
import com.revature.services.PlayerServiceImpl;

public class MainDriver {
	
	static ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
	private static Logger log = Logger.getLogger(MainDriver.class);
	
	public static void main(String[] args) {
		log.info("In main driver...printing player summary of high scores...");
		PlayerService playerService = appContext.getBean(PlayerServiceImpl.class);
		
		List<Player> list = playerService.getAllPlayers();
		
		System.out.println("\nPlayer Summary:");
		list.forEach((Player player) -> {
			System.out.println(String.format("Gamer tag %s (aka %s) has a high score of %d.", player.getGamerTag(), player.getName(), player.getHighScore()));
		});
	}

}
