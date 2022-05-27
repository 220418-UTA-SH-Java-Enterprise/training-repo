package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository; 
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Trainer;

@Repository
@Transactional
public interface TrainerRepository extends JpaRepository<Trainer, Integer>{

	@Modifying
	@Query(value="UPDATE trainers SET trainer_name=?1, trainer_hometown=?2, trainer_username=?3, trainer_password=?4 WHERE trainer_id=?5", nativeQuery = true)
	public int update(String name, String hometown, String username, String password, int id);
	
	@Query(value="SELECT * FROM trainers where trainer_id=?1", nativeQuery = true)
	public Trainer findById(int id);

	@Query(value="SELECT * FROM trainers where trainer_username=?1", nativeQuery = true)
	public Trainer findByUsername(String username);
}
