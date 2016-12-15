package com.fs.store.utils;


import org.springframework.security.core.context.SecurityContextHolder;

import com.fs.store.security.User;

public class UserUtils {
	
	private UserUtils() {
		
	}
	
	public static User getUser() {
		Object principal;
		
		try {
			principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception ex) {
			return null;
		}
		
		if (principal == null || !(principal instanceof User)) {
			return null;
		}
		
		return (User) principal;
	}
}
