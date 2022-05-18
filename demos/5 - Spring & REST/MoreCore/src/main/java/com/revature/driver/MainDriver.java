package com.revature.driver;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.model.Player;
import com.revature.services.PlayerService;

public class MainDriver {
	
static ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
	
	public static void main(String[] args) {
		PlayerService playerService = appContext.getBean(PlayerService.class);
		
		List<Player> list = playerService.getAllPlayers();
		
		System.out.println("\nPlayer Summary:");
		list.forEach((Player player) -> {
			System.out.println(String.format("Gamer tag %s (aka %s) has a high score of %d.", player.getGamerTag(), player.getName(), player.getHighScore()));
		});
	}

}
