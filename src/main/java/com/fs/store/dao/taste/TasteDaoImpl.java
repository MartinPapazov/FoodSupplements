package com.fs.store.dao.taste;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fs.store.entities.Product;
import com.fs.store.entities.ProductTaste;

@Repository
public class TasteDaoImpl implements TasteDao {

	private static final Logger logger = LoggerFactory.getLogger(TasteDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<ProductTaste> getAllTastes() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(ProductTaste.class);
		return criteria.list();
	}

	@Override
	public boolean removeTaste(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeProductTaste(ProductTaste taste, Product product) {
		Session session = sessionFactory.openSession();
		String sql = "delete from product_per_taste where product_id = :product_id AND taste_id = :taste_id";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter("product_id", product.getId());
		query.setParameter("taste_id", taste.getId());
		
		query.executeUpdate();
		return true;
	}

	@Override
	public boolean addTaste(ProductTaste taste) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addTasteToProduct(ProductTaste taste, Product product) {
		Session session = sessionFactory.openSession();
		String sql = "insert into product_per_taste(product_id, taste_id) values(:product_id, :taste_id)";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter("product_id", product.getId());
		query.setParameter("taste_id", taste.getId());
		
		query.executeUpdate();
		return true;
	}

}
