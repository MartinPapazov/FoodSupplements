package com.fs.store.services.authority;

import com.fs.store.entities.Authority;

public interface AuthorityService {

	Authority getAuthority(String name);
	
	Authority getUserAuthority();
	
	Authority getAdminAuthority();
}
