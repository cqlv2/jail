package fr.stazi.epsi.spring.boot.security;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.stazi.epsi.spring.boot.entity.Right;
import fr.stazi.epsi.spring.boot.entity.Role;
import fr.stazi.epsi.spring.boot.entity.User;
import fr.stazi.epsi.spring.boot.repository.UserRepository;



@Primary
@Service
@Transactional
public class SecurityUserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username));
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		if (user.getRoles() != null) {
			for (Role role : user.getRoles()) {
				authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRole().name()));			
				for (Right right : role.getRight()) {
					authorities.add(new SimpleGrantedAuthority(right.getDroit().name()));
				}
			}
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
	}
}
