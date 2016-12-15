package com.fs.store.services.category;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fs.store.entities.Category;
import com.fs.store.entities.Subcategory;
import com.fs.store.utils.exception.EmptyValueException;

public interface CategoryService {
	
	List<Category> getAllCategories();

	boolean addCategory(Category category);

	List<Subcategory> getAllSubcategories();
	
	boolean addSubcategory(Subcategory subcategory);

	boolean removeCategory(Category category);
	
}
