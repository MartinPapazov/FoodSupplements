package com.fs.store.dao.user;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fs.store.constants.DatabaseConstants;
import com.fs.store.entities.Customer;

@Repository
public class UserDaoImpl implements UserDao {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Customer getUser(String username) {
		Criteria criteria = sessionFactory.openSession().createCriteria(Customer.class);
	
		criteria.add(Restrictions.eq(DatabaseConstants.USERNAME, username));
	    List<Customer> users = criteria.list();
	    if (users == null || users.size() <= 0) {
	    	return null;
	    }
	    
	    Customer user = users.get(0);
	    return user;
	}

	@Override
	public List<Customer> getUsers(String username, String status) {
		Criteria criteria = sessionFactory.openSession().createCriteria(Customer.class);
		if (username != null && !username.isEmpty()) {
			criteria.add(Restrictions.eq(DatabaseConstants.USERNAME, username));
		}
		
		if (status != null && !status.isEmpty()) {
			criteria.add(Restrictions.eq(DatabaseConstants.STATUS, status));
		}
		
		return criteria.list();
	}

	@Override
	@Transactional
	public boolean createUser(Customer customer) {
		try (Session session = sessionFactory.openSession();) {
			Transaction tx = session.beginTransaction();
			session.save(customer);
			tx.commit();
		} catch (Exception ex) {
			logger.error("Trying to create customer!", ex);
			return false;
		}
		
		return true;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		try (Session session = sessionFactory.openSession();) {
			Transaction tx = session.beginTransaction();
			session.update(customer);
			tx.commit();
		} catch (Exception ex) {
			logger.error("Trying to update customer!", ex);
			return false;
		}
		
		return true;
	}

}
