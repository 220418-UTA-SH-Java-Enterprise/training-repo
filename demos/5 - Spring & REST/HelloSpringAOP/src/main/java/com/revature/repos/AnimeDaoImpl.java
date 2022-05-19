package com.revature.repos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.revature.models.Anime;

@Repository
public class AnimeDaoImpl implements AnimeDao{

	@Override
	public List<Anime> selectAll() {
		List<Anime> animes = new ArrayList<>();
		
		animes.add(new Anime(1, "Dragon Ball Z", "Goku"));
		animes.add(new Anime(2, "One Piece", "Luffy"));
		animes.add(new Anime(3, "Hunter X Hunter", "Gon"));
		
		return animes;
	}

}
