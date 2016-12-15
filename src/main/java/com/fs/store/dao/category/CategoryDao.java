package com.fs.store.dao.category;

import java.util.List;

import com.fs.store.entities.Category;
import com.fs.store.entities.Subcategory;

public interface CategoryDao {

	List<Category> getAllCategories();
	
	boolean addCategory(Category category);

	Category getCategory(int id);
	
	boolean removeCategory(Category category);
	
	
	List<Subcategory> getAllSubcategories();

	boolean addSubcategory(Subcategory subcategory);
	
	boolean removeSubcategory(Subcategory subcategory);


}
