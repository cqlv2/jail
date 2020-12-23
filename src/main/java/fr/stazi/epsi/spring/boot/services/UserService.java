package fr.stazi.epsi.spring.boot.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.stazi.epsi.spring.boot.entity.User;

@Service
public class UserService {
	
	private UserRepository userRepo;

	public UserService(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	public List<User> getAll() {
		return userRepo.findAll();
	}
}
