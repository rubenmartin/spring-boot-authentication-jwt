package com.bedirhanatasoy.springboot.auth.service;

import java.util.Optional;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bedirhanatasoy.springboot.auth.domain.User;
import com.bedirhanatasoy.springboot.auth.enums.Role;
import com.bedirhanatasoy.springboot.auth.repository.UserRepository;

public class UserService implements UserDetailsService {

	@SuppressWarnings("unused")
	private final Logger logger = Logger.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUsername(username);
		if (user.isPresent()) {
			return user.get();
		} else {
			throw new UsernameNotFoundException(String.format("Username[%s] not found", username));
		}
	}

	public User findUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUsername(username);
		if (user.isPresent()) {
			return user.get();
		} else {
			throw new UsernameNotFoundException(String.format("Username[%s] not found", username));
		}
	}

	public User registerUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.grantAuthority(Role.ROLE_USER);
		return userRepository.save(user);
	}

}
