package com.fs.store.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fs.store.constants.DatabaseConstants;
import com.fs.store.constants.UrlConstants;
import com.fs.store.entities.Product;
import com.fs.store.entities.ProductDetails;
import com.fs.store.services.product.ProductService;

@Controller
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	
	@Autowired
	private ProductService service;
	

	@RequestMapping(value = UrlConstants.ALL_PRODUCTS, method = RequestMethod.GET)
	public @ResponseBody List<Product> getAllProducts() {
		List<Product> products = service.getAllProducts();
		
		return products;
	}
	
	@RequestMapping(value = UrlConstants.GET_PRODUCT_BY_ID, method = RequestMethod.POST)
	public @ResponseBody Product getProductById(@RequestBody Product product) {
		Product productById = service.getProductById(product.getId());
		
		return productById;
	}
	
	@Secured(DatabaseConstants.ROLE_ADMIN)
	@RequestMapping(value = UrlConstants.REMOVE_PRODUCT, method = RequestMethod.POST)
	public @ResponseBody Product removeProduct(@RequestBody Product product) {
		service.deleteProduct(product);
		return product;
	}
	
	@Secured(DatabaseConstants.ROLE_ADMIN)
	@RequestMapping(value = UrlConstants.ADD_PRODUCT, method = RequestMethod.POST)
	public @ResponseBody Product addCategory(@RequestBody Product product) {
		service.addProduct(product);
		return product;
	}
	
	@RequestMapping(value = UrlConstants.GET_PRODUCT_DETAILS_BY_PRODUCT_ID, method = RequestMethod.POST)
	public @ResponseBody List<ProductDetails> getProductDetailsByProductId(@RequestBody Product product) {
		return service.getAllDetails(product);
	}
	
	@RequestMapping(value = UrlConstants.GET_PRODUCT_DETAILS_BY_ID, method = RequestMethod.POST)
	public @ResponseBody ProductDetails getProductDetailsById(@RequestBody ProductDetails productDetails) {
		return service.getProductDetailById(productDetails.getId());
	}
	
	@RequestMapping(value = UrlConstants.ADD_PRODUCT_DETAILS, method = RequestMethod.POST)
	public @ResponseBody ProductDetails addProductDetails(
			@RequestParam("product_id") String productId,
			@RequestParam("quantity") String quantity,
			@RequestParam("old_price") String oldPrice, 
			@RequestParam("current_price") String currentPrice, 
			@RequestParam("image_product") MultipartFile file) 
	{

		ProductDetails details = new ProductDetails();
		Product product = new Product();
		product.setId(Integer.parseInt(productId));
		details.setProduct(product);
		try {
			details.setQuantity(new String (quantity.getBytes("iso-8859-1"), "UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			logger.error(e1.getMessage());
		}
		details.setOldPrice(Double.parseDouble(oldPrice));
		details.setCurrentPrice(Double.parseDouble(currentPrice));
		if (file != null) {
			byte[] image;
			try {
				image = file.getBytes();
				details.setImage(image);
			} catch (IOException e) {
				// TODO: Log it
			}
		}
		service.addProductDetails(details);
		return details;
	}
	
	@RequestMapping(value = UrlConstants.REMOVE_PRODUCT_DETAILS, method = RequestMethod.POST)
	public @ResponseBody ProductDetails removeProductDetails(@RequestBody ProductDetails details) {
		logger.info("Removing product details.");
		boolean removed = service.removeProductDetails(details); 
		
		if (removed) {
			return details;
		} else {
			return null;
		}
	}
}
