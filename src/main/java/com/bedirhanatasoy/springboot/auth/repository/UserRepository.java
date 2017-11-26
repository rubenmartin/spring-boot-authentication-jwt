package com.bedirhanatasoy.springboot.auth.repository;

import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.bedirhanatasoy.springboot.auth.domain.User;

public interface UserRepository extends Repository<User, Long> {

	Optional<User> findByUsername(String username);

	User save(User user);

	int deleteUserById(Long id);
}
