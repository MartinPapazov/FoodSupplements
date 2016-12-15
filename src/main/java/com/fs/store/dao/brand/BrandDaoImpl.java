package com.fs.store.dao.brand;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fs.store.constants.DatabaseConstants;
import com.fs.store.entities.Authority;
import com.fs.store.entities.Brand;

@Repository
public class BrandDaoImpl implements BrandDao {

	private static final Logger logger = LoggerFactory.getLogger(BrandDao.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Brand> getAllBrands() {
		Criteria cr = sessionFactory.openSession().createCriteria(Brand.class)
			    .setProjection(Projections.projectionList()
			      .add(Projections.property("id"), "id")
			      .add(Projections.property("name"), "name")
			      .add(Projections.property("description"), "description"))
			    .setResultTransformer(Transformers.aliasToBean(Brand.class));
		return cr.list();
	}

	@Override
	@Transactional
	public boolean addBrand(Brand brand) {
		try (Session session = sessionFactory.openSession();) {
			Transaction tx = session.beginTransaction();
			session.save(brand);
			tx.commit();
		} catch (Exception ex) {
			logger.error("Trying to create Brand!", ex);
			return false;
		}
		
		return true;
	}
	
	@Override
	public boolean changeBrand(Brand brand) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Brand getBrandById(int id) {
		Criteria criteria = sessionFactory.openSession().createCriteria(Brand.class);
		
		criteria.add(Restrictions.eq(DatabaseConstants.ID, id));
	    List<Brand> brands = criteria.list();
	    if (brands == null || brands.size() <= 0) {
	    	return null;
	    }
	    
	    Brand brand = brands.get(0);
	    return brand;
	}

	@Override
	public boolean removeBrand(Brand brand) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("delete Brand where id = :ID");
		query.setParameter("ID", brand.getId());
		
		int result = query.executeUpdate();
		 
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}


}
