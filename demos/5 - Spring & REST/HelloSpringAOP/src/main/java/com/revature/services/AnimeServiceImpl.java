package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Anime;
import com.revature.repos.AnimeDao;

@Service
public class AnimeServiceImpl implements AnimeService{
	private AnimeDao animeDao;
	
	@Autowired
	public AnimeServiceImpl(AnimeDao animeDao) {
		this.animeDao = animeDao;
	}

	@Override
	public List<Anime> getAllAnimeShows() {
		return animeDao.selectAll();
	}

}
