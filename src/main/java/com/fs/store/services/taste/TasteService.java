package com.fs.store.services.taste;

import java.util.List;

import com.fs.store.entities.Product;
import com.fs.store.entities.ProductTaste;

public interface TasteService {

	List<ProductTaste> getAllTastes();
	
	boolean removeTaste(int id);
	
	boolean removeProductTaste(ProductTaste taste, Product product);
	
	boolean addTaste(ProductTaste taste);
	
	boolean addTasteToProduct(ProductTaste taste, Product product);
	
}
