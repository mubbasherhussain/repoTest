package com.grow.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grow.demo.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
