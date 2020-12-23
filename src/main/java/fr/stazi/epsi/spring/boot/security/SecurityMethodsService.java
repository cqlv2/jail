package fr.stazi.epsi.spring.boot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import fr.stazi.epsi.spring.boot.entity.User;
import fr.stazi.epsi.spring.boot.repository.UserRepository;

@Service
public class SecurityMethodsService {
	
	@Autowired
	private UserRepository userRepository;
	
	public boolean isConnectedUser(Integer userId, UserDetails connectedUser) {
		User user = userRepository.findById(userId).orElse(null);
		return user != null && user.getEmail().equals(connectedUser.getUsername());
	}
	public boolean canManage(Long cellId, UserDetails connectedUser){
		User u=userRepository.findByEmail(connectedUser.getUsername()).orElse(null);
		return u.getCells().parallelStream().anyMatch(cell-> cell.getId().equals(cellId));
	}


}
