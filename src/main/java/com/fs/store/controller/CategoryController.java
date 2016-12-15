package com.fs.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fs.store.constants.UrlConstants;
import com.fs.store.entities.Category;
import com.fs.store.entities.Subcategory;
import com.fs.store.services.category.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService catService;
	
	
	//Categories
	@RequestMapping(value = UrlConstants.ALL_CATEGORY, method = RequestMethod.GET)
	public @ResponseBody List<Category> getAllCategories() {
		
		return catService.getAllCategories();
	}
	
	@RequestMapping(value = UrlConstants.ADD_CATEGORY, method = RequestMethod.POST)
	public @ResponseBody Category addCategory(@RequestBody Category category) {
		
		catService.addCategory(category);
		
		return category;
	}
	
	@RequestMapping(value = UrlConstants.REMOVE_CATEGORY, method = RequestMethod.POST)
	public @ResponseBody Category removeCategory(@RequestBody Category category) {
		catService.removeCategory(category);
		return category;
	}
	
	//Subcategories
	
	@RequestMapping(value = UrlConstants.ALL_SUBCATEGORY, method = RequestMethod.GET)
	public @ResponseBody List<Subcategory> getAllSubcategories() {
		
		return catService.getAllSubcategories();
	}
	
	@RequestMapping(value = UrlConstants.ADD_SUBCATEGORY, method = RequestMethod.POST)
	public @ResponseBody Subcategory addSubcategory(@RequestBody Subcategory subcategory) {
		boolean added = catService.addSubcategory(subcategory);
		if (added) {
			return subcategory;
		}
		
		return null;
	}
	
	
}
