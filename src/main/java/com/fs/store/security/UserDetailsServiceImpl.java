package com.fs.store.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.fs.store.dao.user.UserDao;
import com.fs.store.entities.Authority;
import com.fs.store.entities.Customer;

public class UserDetailsServiceImpl implements UserDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<GrantedAuthority> authorties = new ArrayList<>();
		logger.info("User: " + username + " is trying to log in.");
		Customer user = userDao.getUser(username);
		if (user == null) {
			logger.info("No such user in database!");
			return new User(username, null, authorties);
		}

		List<Authority> authorities = user.getAuthorities();
		if (authorities.isEmpty()) {
			logger.warn("User: " + username + " do not have any authorities!");
		}
		for (Authority authority : authorities) {
			authorties.add(new SimpleGrantedAuthority(authority.getAuthority()));
		}
		
		return new User(user.getUsername(), user.getPassword(), authorties);
	}
}
