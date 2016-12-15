package com.fs.store.services.authority;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fs.store.constants.DatabaseConstants;
import com.fs.store.dao.authority.AuthorityDao;
import com.fs.store.entities.Authority;

@Service	
public class AuthoritySeviceImpl implements AuthorityService {
	
	@Autowired
	private AuthorityDao authDao;
	
	@Override
	public Authority getAuthority(String name) {
		return authDao.getAuthority(name);
	}

	@Override
	public Authority getUserAuthority() {
		return authDao.getAuthority(DatabaseConstants.ROLE_USER);
	}

	@Override
	public Authority getAdminAuthority() {
		return authDao.getAuthority(DatabaseConstants.ROLE_ADMIN);
	}

}
