package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Trainer;
import com.revature.repository.TrainerRepository;

@Service
@Transactional
public class TrainerServiceImpl implements TrainerService{

	@Autowired
	private TrainerRepository trainerRepo;
	
	@Override
	public boolean registerTrainer(Trainer trainer) {
		int pk = trainerRepo.save(trainer).getTrainerId();
		return (pk > 0) ? true : false;
	}

	@Override
	public Trainer getTrainerById(int id) {
		return trainerRepo.findById(id);
	}

	@Override
	public List<Trainer> getAllTrainers() {
		return trainerRepo.findAll();
	}

	@Override
	public boolean updateTrainer(Trainer trainer) {
		return (trainerRepo.update(trainer.getTrainerName(), trainer.getHometown(), trainer.getUsername(), trainer.getPassword(), trainer.getTrainerId()) != 0) ? true : false;
	}

	@Override
	public boolean deleteTrainer(Trainer trainer) {
		try {
			trainerRepo.delete(trainer);
			return true;
		}catch(Exception e) {
			System.out.println("Error occur during deletion:: " + e);
			return false;
		}
	}

}
