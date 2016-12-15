package com.fs.store.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fs.store.constants.UrlConstants;
import com.fs.store.entities.Product;
import com.fs.store.entities.ProductTaste;
import com.fs.store.services.taste.TasteService;

@Controller
public class TasteController {

	private static final Logger logger = LoggerFactory.getLogger(TasteController.class);
	private static final String PRODUCT_ID = "productId";
	private static final String TASTE_ID = "tasteId";

	@Autowired
	private TasteService service;

	@RequestMapping(value = UrlConstants.REMOVE_PRODUCT_TASTE, method = RequestMethod.POST)
	public @ResponseBody ProductTaste removeProductTaste(@RequestBody Map<String, String> json) {
		int productId = Integer.parseInt(json.get(PRODUCT_ID));
		int tasteId = Integer.parseInt(json.get(TASTE_ID));
		logger.info("Deleting from product \"" + productId + "\" taste \"" + tasteId + "\"");
		ProductTaste taste = new ProductTaste();
		taste.setId(tasteId);

		Product product = new Product();
		product.setId(productId);

		boolean removed = service.removeProductTaste(taste, product);
		if (removed) {
			return taste;
		} else {
			return null;
		}
	}

	@RequestMapping(value = UrlConstants.ADD_PRODUCT_TASTE, method = RequestMethod.POST)
	public @ResponseBody ProductTaste addProductTaste(@RequestBody Map<String, String> json) {
		int productId = Integer.parseInt(json.get(PRODUCT_ID));
		int tasteId = Integer.parseInt(json.get(TASTE_ID));
		logger.info("Adding in product \"" + productId + "\" taste \"" + tasteId + "\"");
		ProductTaste taste = new ProductTaste();
		taste.setId(tasteId);

		Product product = new Product();
		product.setId(productId);

		boolean added = service.addTasteToProduct(taste, product);
		if (added) {
			return taste;
		} else {
			return null;
		}
	}
	
	@RequestMapping(value = UrlConstants.ALL_TASTES, method = RequestMethod.GET)
	public @ResponseBody List<ProductTaste> getAllTastes() {
		return service.getAllTastes();
	}
}
