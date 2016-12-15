package com.fs.store.services.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fs.store.dao.category.CategoryDao;
import com.fs.store.entities.Category;
import com.fs.store.entities.Subcategory;
import com.fs.store.utils.exception.EmptyValueException;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public List<Category> getAllCategories() {
		return categoryDao.getAllCategories();
	}

	@Override
	public boolean addCategory(Category category) {
		return categoryDao.addCategory(category);
	}

	@Override
	public List<Subcategory> getAllSubcategories() {
		return categoryDao.getAllSubcategories();
	}

	@Override
	public boolean addSubcategory(Subcategory subcategory) {
		return categoryDao.addSubcategory(subcategory);
		
	}

	@Override
	public boolean removeCategory(Category category) {
		return categoryDao.removeCategory(category);
	}
}
