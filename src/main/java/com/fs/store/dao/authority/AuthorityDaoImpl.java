package com.fs.store.dao.authority;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fs.store.constants.DatabaseConstants;
import com.fs.store.entities.Authority;

@Repository
public class AuthorityDaoImpl implements AuthorityDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Authority> getAuthorities() {
		String sql = "FROM Authority";
		Query query = sessionFactory.openSession().createQuery(sql);
		return query.list();
	}

	@Override
	public Authority getAuthority(String name) {
		Criteria criteria = sessionFactory.openSession().createCriteria(Authority.class);
		
		criteria.add(Restrictions.eq(DatabaseConstants.AUTHORITY, name));
	    List<Authority> authorities = criteria.list();
	    if (authorities == null || authorities.size() <= 0) {
	    	return null;
	    }
	    
	    Authority authority = authorities.get(0);
	    return authority;
	}

}
