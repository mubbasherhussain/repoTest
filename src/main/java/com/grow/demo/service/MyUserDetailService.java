package com.grow.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.grow.demo.dao.RoleRepository;
import com.grow.demo.dao.UserRepository;
import com.grow.demo.dao.UsersRolesRepository;
import com.grow.demo.model.Role;
import com.grow.demo.model.User;
import com.grow.demo.model.UsersRoles;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RoleRepository roleRepo;	
	@Autowired
	private UsersRolesRepository urRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepo.findByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException("Invalid USer");
		
		UsersRoles usersroles = urRepo.findByUserid(user.getId());
		if (usersroles == null)
			throw new UsernameNotFoundException("Invalid USers Roles");
			  
		Optional<Role> role = roleRepo.findById(usersroles.getRoleid());
		if (role == null)
			throw new UsernameNotFoundException("Invalid Role");
		
		return new UserPrincipal(user,role);
	}
}
