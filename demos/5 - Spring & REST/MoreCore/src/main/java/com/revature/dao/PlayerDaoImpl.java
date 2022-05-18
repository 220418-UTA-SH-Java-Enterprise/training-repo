package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.revature.model.Player;

//this is an sterotype annotation that denotes this class as a dao component for spring to scan for
@Repository
public class PlayerDaoImpl implements PlayerDao {

	private static Logger log = Logger.getLogger(PlayerDaoImpl.class);
	
	@Override
	public List<Player> getAll() {
		// For good practice, we need to log the activity of this method into our log file
		//use Reflections within my log message
		log.info(String.format("%s --> getting all players in database...", getClass().getMethods()[0].getName()));
		
		//implement logic here
		List<Player> players = new ArrayList<>();
		
		players.add(new Player("AAK", "Azhya Knox", 2_820_109));
		players.add(new Player("CAT", "Cathy Gray", 283_802));
		players.add(new Player("YAY", "Yasir Bello", 3_873_801));
		players.add(new Player("YOLO", "Cool Dude", 1_000_000_000));
		
		return players;
	}

}
