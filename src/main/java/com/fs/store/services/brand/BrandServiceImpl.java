package com.fs.store.services.brand;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fs.store.dao.brand.BrandDao;
import com.fs.store.entities.Brand;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandDao brandDao;
	
	@Override
	public List<Brand> getAllBrands() {
		List<Brand> brands = brandDao.getAllBrands();
		for (Brand brand : brands) {
			byte[] arr = brand.getImage();
		}
		
		return brands;
	}

	@Override
	public boolean addBrand(Brand brand) {
		return brandDao.addBrand(brand);
	}
	
	@Override
	public boolean changeBrand(Brand brand) {
		return brandDao.changeBrand(brand);
	}

	@Override
	public Brand getBrandById(int id) {
		return brandDao.getBrandById(id);
	}

	@Override
	public void removeBrand(Brand brand) {	
		brandDao.removeBrand(brand);
	}

}
