package com.fs.store.dao.product;

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
import com.fs.store.entities.Product;
import com.fs.store.entities.ProductDetails;

@Repository
public class ProductDaoImpl implements ProductDao{

private static final Logger logger = LoggerFactory.getLogger(ProductDao.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Product> getAllProducts() {
		logger.info("Getting all products");
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Product.class);
		
		return criteria.list();
	}

	@Override
	public Product getProductById(int id) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Product.class);
		
		criteria.add(Restrictions.eq(DatabaseConstants.ID, id));
		List<Product> products = criteria.list();
	    if (products == null || products.size() <= 0) {
	    	return null;
	    }
	    
	    Product product = products.get(0);
		return product;
	}

	@Override
	@Transactional
	public boolean addProduct(Product product) {
		try (Session session = sessionFactory.openSession();) {
			Transaction tx = session.beginTransaction();
			session.save(product);
			tx.commit();
		} catch (Exception ex) {
			logger.error("Trying to create Product!", ex);
			return false;
		}
		
		return true;
	}
	
	@Override
	public boolean changeProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}
	

	@Override
	public boolean deleteProduct(Product product) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("delete Product where id = :ID");
		query.setParameter("ID", product.getId());
		
		int result = query.executeUpdate();
		 
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<ProductDetails> getAllDetails(Product product) {
		logger.info("Getting all products details");
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(ProductDetails.class);
		criteria.add(Restrictions.eq("productId", product.getId()));
		
		return criteria.list();
	}

	@Override
	public ProductDetails getProductDetailById(int id) {
		logger.info("Getting product detail by id: " + id);
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(ProductDetails.class);
		
		criteria.add(Restrictions.eq(DatabaseConstants.ID, id));
		List<ProductDetails> details =  criteria.list();
		if ( details == null || details.size() <= 0 ) {
			return null;
		}
		
		return details.get(0);

	}

	@Override
	public boolean addProductDetails(ProductDetails productDetails) {
		try (Session session = sessionFactory.openSession();) {
			Transaction tx = session.beginTransaction();
			session.save(productDetails);
			tx.commit();
		} catch (Exception ex) {
			logger.error("Trying to create Product Details!", ex);
			return false;
		}
		
		return true;
	}

	@Override
	public boolean changeProductDetails(ProductDetails productDetails) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeProductDetails(ProductDetails productDetails) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("delete ProductDetails where id = :ID");
		query.setParameter("ID", productDetails.getId());
		
		int result = query.executeUpdate();
		 
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

}
