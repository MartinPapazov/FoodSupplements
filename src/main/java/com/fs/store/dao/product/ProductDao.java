package com.fs.store.dao.product;

import java.util.List;

import com.fs.store.entities.Product;
import com.fs.store.entities.ProductDetails;

public interface ProductDao {

	List<Product> getAllProducts();
	
	Product getProductById(int id);
	
	boolean addProduct(Product product);

	boolean changeProduct(Product product);
	
	boolean deleteProduct(Product product);
	
	List<ProductDetails> getAllDetails(Product product);
	
	ProductDetails getProductDetailById(int id);
	
	boolean addProductDetails(ProductDetails productDetails);
	
	boolean changeProductDetails(ProductDetails productDetails);

	boolean removeProductDetails(ProductDetails productDetails);
}
