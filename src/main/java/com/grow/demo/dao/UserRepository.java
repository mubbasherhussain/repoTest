package com.grow.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grow.demo.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);
}
