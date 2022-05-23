package com.revature.service;

import java.util.List;

import com.revature.model.Trainer;

public interface TrainerService {

	//create a new trainer
	boolean registerTrainer(Trainer trainer);
	
	//get trainer by id
	Trainer getTrainerById(int id);
	
	//get all candies
	List<Trainer> getAllTrainers();
	
	//update trainer info
	boolean updateTrainer(Trainer trainer);
	
	//delete a trainer
	boolean deleteTrainer(Trainer trainer);
}
