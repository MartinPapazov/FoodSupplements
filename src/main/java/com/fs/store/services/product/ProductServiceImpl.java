package com.fs.store.services.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fs.store.dao.product.ProductDao;
import com.fs.store.entities.Product;
import com.fs.store.entities.ProductDetails;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;
	
	@Override
	public List<Product> getAllProducts() {
		List<Product> products = dao.getAllProducts();
		for (int i = 0; i < products.size(); i++) {
			Product product = products.get(i);
			product.getBrand().setImage(null);;
		}
		
		return products;
	}

	@Override
	public Product getProductById(int id) {
		return dao.getProductById(id);
	}

	@Override
	public boolean addProduct(Product product) {
		return dao.addProduct(product);
	}
	
	@Override
	public boolean changeProduct(Product product) {
		return dao.changeProduct(product);
	}

	@Override
	public boolean deleteProduct(Product product) {
		return dao.deleteProduct(product);
	}



	@Override
	public List<ProductDetails> getAllDetails(Product product) {
		return dao.getAllDetails(product);
	}

	@Override
	public ProductDetails getProductDetailById(int id) {
		return dao.getProductDetailById(id);
	}

	@Override
	public boolean addProductDetails(ProductDetails productDetails) {
		return dao.addProductDetails(productDetails);
	}

	@Override
	public boolean changeProductDetails(ProductDetails productDetails) {
		return dao.changeProductDetails(productDetails);
	}

	@Override
	public boolean removeProductDetails(ProductDetails productDetails) {
		return dao.removeProductDetails(productDetails);
	}

}
