package com.revature.model;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
@Table(name="trainers")
@ApiModel(value = "Trainer", description = "This model serves as basic model for all trainer entity API operations")
public class Trainer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="trainer_id")
	@ApiModelProperty(name="TrainerID", 
	notes="an Integer value that serves as the unique identier for any trainer entity",
	required = true,
	value = "1")
	private int trainerId;
	
	@Column(name="trainer_name", nullable=false)
	@ApiModelProperty(name="Trainer Name", 
	notes="a String value that serves as the Trainer's full name",
	required = true,
	value = "TEST_TRAINER_NAME")
	private String trainerName;
	
	@Column(name="trainer_hometown")
	@ApiModelProperty(name="Hometown", 
	notes="a String value that serves as the hometown of the trainer",
	value = "TEST_TRAINER_HOMETOWN_NAME")
	private String hometown;
	
	@Column(name="trainer_username", unique=true, nullable=false)
	@ApiModelProperty(name="Username", 
	notes="an unique String value that serves as the Trainer's username for the API",
	required = true,
	value = "TEST_TRAINER_USERNAME")
	private String username;
	
	@Column(name="trainer_password", nullable=false)
	@ApiModelProperty(name="Password", 
	notes="an String value that serves as the Trainer's password for the API",
	required = true,
	value = "TEST_TRAINER_PASSWORD")
	private String password;
	
	public Trainer() {}

	public Trainer(String trainerName, String hometown, String username, String password) {
		super();
		this.trainerName = trainerName;
		this.hometown = hometown;
		this.username = username;
		this.password = password;
	}

	public Trainer(int trainerId, String trainerName, String hometown, String username, String password) {
		super();
		this.trainerId = trainerId;
		this.trainerName = trainerName;
		this.hometown = hometown;
		this.username = username;
		this.password = password;
	}
}
