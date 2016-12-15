package com.fs.store.services.taste;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fs.store.dao.taste.TasteDao;
import com.fs.store.entities.Product;
import com.fs.store.entities.ProductTaste;

@Service
public class TasteServiceImpl implements TasteService {

	@Autowired
	private TasteDao dao;
	
	@Override
	public List<ProductTaste> getAllTastes() {
		return dao.getAllTastes();
	}

	@Override
	public boolean removeTaste(int id) {
		return dao.removeTaste(id);
	}

	@Override
	public boolean removeProductTaste(ProductTaste taste, Product product) {
		return dao.removeProductTaste(taste, product);
	}

	@Override
	public boolean addTaste(ProductTaste taste) {
		return dao.addTaste(taste);
	}

	@Override
	public boolean addTasteToProduct(ProductTaste taste, Product product) {
		return dao.addTasteToProduct(taste, product);
	}

}
