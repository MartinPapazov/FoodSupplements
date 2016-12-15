package com.fs.store.services.customer;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fs.store.constants.DatabaseConstants;
import com.fs.store.dao.user.UserDao;
import com.fs.store.entities.Authority;
import com.fs.store.entities.Customer;
import com.fs.store.services.authority.AuthorityService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private AuthorityService authService;
	
	@Override
	public Customer getCustomer(String username) {
		return userDao.getUser(username);
	}

	@Override
	public List<Customer> getCustomers(String username, String status) {
		return userDao.getUsers(username, status);
	}

	@Override
	public boolean addUser(Customer customer) {
		customer.setIsActive(DatabaseConstants.STATUS_ACTIVE);
		customer.setCreated(new Date());
		String encryptedPassword = encryptPassword(customer.getPassword());
		customer.setPassword(encryptedPassword);
		
		boolean isUserCreated = userDao.createUser(customer);
		if (!isUserCreated) {
			return false;
		}
		
		Customer createdCustomer = this.getCustomer(customer.getUsername());
		Authority auth = authService.getUserAuthority();
		List<Authority> auths = new ArrayList<>(1);
		auths.add(auth);
		createdCustomer.setAuthorities(auths);
		
		return this.updateCustomer(createdCustomer);
	}

	private String encryptPassword(String password) {
		 try {
			 MessageDigest m = MessageDigest.getInstance("MD5");
			 m.reset();
			 m.update(password.getBytes());
			 byte[] digest = m.digest();
			 BigInteger bigInt = new BigInteger(1,digest);
			 String hashtext = bigInt.toString(16);
			 // Now we need to zero pad it if you actually want the full 32 chars.
			 while(hashtext.length() < 32 ){
			   hashtext = "0"+hashtext;
			 }
	        return hashtext;
		} catch (NoSuchAlgorithmException e) {
			logger.error("Trying to encrypt password.", e );
		}
		 
		 return password;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		return userDao.updateCustomer(customer);
	}
	
	
}
