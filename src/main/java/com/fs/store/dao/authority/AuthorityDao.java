package com.fs.store.dao.authority;

import java.util.List;

import com.fs.store.entities.Authority;

public interface AuthorityDao {
	
	List<Authority> getAuthorities();
	
	Authority getAuthority(String name);
}
