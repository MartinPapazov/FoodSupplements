package com.fs.store.dao.category;

import java.util.List;
import java.util.stream.Collectors;

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
import com.fs.store.entities.Brand;
import com.fs.store.entities.Category;
import com.fs.store.entities.Subcategory;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	
	private static final Logger logger = LoggerFactory.getLogger(Category.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Category> getAllCategories() {
		Criteria criteria = sessionFactory.openSession().createCriteria(Category.class);
		List<Category> categories = criteria.list();
		
		logger.info("[" + categories.stream()
				  .map(Category::getName)
				  .collect(Collectors.joining(", ")) + "]");
		return categories;
	}

	@Override
	@Transactional
	public boolean addCategory(Category category) {
		try (Session session = sessionFactory.openSession();) {
			Transaction tx = session.beginTransaction();
			session.save(category);
			tx.commit();
		} catch (Exception ex) {
			logger.error("Trying to create category!", ex);
			return false;
		}
		
		return true;
	}

	@Override
	public Category getCategory(int id) {
		Criteria criteria = sessionFactory.openSession().createCriteria(Category.class);
		
		criteria.add(Restrictions.eq(DatabaseConstants.ID, id));
	    List<Category> categories = criteria.list();
	    if (categories == null || categories.size() <= 0) {
	    	return null;
	    }
	    
	    Category category = categories.get(0);
	    return category;
	}
	
	@Override
	@Transactional
	public boolean removeCategory(Category category) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("delete Category where id = :ID");
		query.setParameter("ID", category.getId());
		
		int result = query.executeUpdate();
		 
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	@Override
	public List<Subcategory> getAllSubcategories() {
		Criteria criteria = sessionFactory.openSession().createCriteria(Subcategory.class);
		
		return criteria.list();
	}

	@Override
	@Transactional
	public boolean addSubcategory(Subcategory subcategory) {
		try (Session session = sessionFactory.openSession();) {
			Transaction tx = session.beginTransaction();
			session.save(subcategory);
			tx.commit();
		} catch (Exception ex) {
			logger.error("Trying to create subcategory!", ex);
			return false;
		}
		
		return true;
	}

	@Override
	public boolean removeSubcategory(Subcategory subcategory) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("delete Subcategory where id = :ID");
		query.setParameter("ID", subcategory.getId());
		
		int result = query.executeUpdate();
		 
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}




}
