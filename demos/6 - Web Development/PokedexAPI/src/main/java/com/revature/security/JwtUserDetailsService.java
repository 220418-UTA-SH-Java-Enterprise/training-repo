package com.revature.security;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Trainer;
import com.revature.repository.TrainerRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private TrainerRepository trepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		boolean isValidTrainer = false;
		if (username != null) {
			// make a repo call to get all trainers using a Stream
			// in stream, do check if trainer username exist in trainer list
			Optional<Trainer> trainers = trepo.findAll()
					.stream()
					.filter(t -> (t.getUsername().equals(username)))
					.findFirst();
			isValidTrainer = trainers.isPresent();
		}else {
			throw new UsernameNotFoundException("Username not provided");
		}
		// authenicate trainer with userdetails
		if (isValidTrainer) {
			return new User(username, "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}
