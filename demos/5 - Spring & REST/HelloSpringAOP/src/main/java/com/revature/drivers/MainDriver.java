package com.revature.drivers;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.revature.config.AppConfig;
import com.revature.models.Anime;
import com.revature.services.AnimeService;
import com.revature.services.AnimeServiceImpl;

public class MainDriver {

	//1. set up my ApplicationContext so I can define the IOC container
	static ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
	
	public static void main(String[] args) {
		// 2. need an instance of my service
		AnimeService animeService = appContext.getBean(AnimeServiceImpl.class);
		
		// 3. print out the contents that I get back from my fake db
		List<Anime> list = animeService.getAllAnimeShows();
		
		System.out.println("\nMy Netflix Watchlist: ");
		for(Anime show : list) {
			System.out.println(show);
		}
	}

}
