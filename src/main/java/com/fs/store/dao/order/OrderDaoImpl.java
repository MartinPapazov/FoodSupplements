package com.fs.store.dao.order;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
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
import com.fs.store.entities.Order;
import com.fs.store.entities.Status;

@Repository
public class OrderDaoImpl implements OrderDao {

	private static final Logger logger = LoggerFactory.getLogger(OrderDao.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Order> getAllOrders() {
		logger.info("Getting all orders");
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Order.class);

		return criteria.list();
	}

	@Override
	public Order getOrderById(int id) {
		logger.info("Getting order by id: " + id);
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Order.class);
		
		criteria.add(Restrictions.eq(DatabaseConstants.ID, id));
		List<Order> orders = criteria.list();
	    if (orders == null || orders.size() <= 0) {
	    	return null;
	    }
	    
	    Order order = orders.get(0);
		return order;
	}

	@Override
	@Transactional
	public boolean addOrder(Order order) {
		try (Session session = sessionFactory.openSession();) {
			Transaction tx = session.beginTransaction();
			session.save(order);
			tx.commit();
		} catch (Exception ex) {
			logger.error("Trying to create Order in database!", ex);
			return false;
		}
		
		return true;
	}

	@Override
	public boolean changeOrder(Order order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteOrder(Order order) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("delete Order where id = :ID");
		query.setParameter("ID", order.getId());
		
		int result = query.executeUpdate();
		 
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean acceptOrder(Order order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean finishOrder(Order order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deniedOrder(Order order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean orderStatusChanged(Status status) {
		// TODO Auto-generated method stub
		return false;
	}

}
