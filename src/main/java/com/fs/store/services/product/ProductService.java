package com.fs.store.services.product;

import java.util.List;

import com.fs.store.entities.Product;
import com.fs.store.entities.ProductDetails;

public interface ProductService {

	/**
	 * Return all products without there images. 
	 * For getting product image use getProductById method.
	 * @return
	 */
	List<Product> getAllProducts();
	
	/**
	 * Return product by given id. <b>Product</b> with image.
	 * @param id
	 * @return
	 */
	Product getProductById(int id);
	
	/**
	 * Add product.
	 * @param product
	 * @return
	 */
	boolean addProduct(Product product);

	/**
	 * Change product.
	 * @param product
	 * @return
	 */
	boolean changeProduct(Product product);
	
	/**
	 * Delete product only Id needed.
	 * @param product
	 * @return
	 */
	boolean deleteProduct(Product product);
	
	
	List<ProductDetails> getAllDetails(Product product);
	
	ProductDetails getProductDetailById(int id);
	
	boolean addProductDetails(ProductDetails productDetails);
	
	boolean changeProductDetails(ProductDetails productDetails);

	boolean removeProductDetails(ProductDetails productDetails);
}
