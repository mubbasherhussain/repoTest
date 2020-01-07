package com.grow.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grow.demo.model.UsersRoles;

public interface UsersRolesRepository extends JpaRepository<UsersRoles, Integer> {
	UsersRoles findByUserid(int id);
}
