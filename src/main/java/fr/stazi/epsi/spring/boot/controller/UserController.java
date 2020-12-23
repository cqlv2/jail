package fr.stazi.epsi.spring.boot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.stazi.epsi.spring.boot.entity.User;
import fr.stazi.epsi.spring.boot.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping
	public List<User> getAll() {
		return userService.getAll();
	}

}
