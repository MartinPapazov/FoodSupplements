package com.fs.store.services.brand;

import java.util.List;

import com.fs.store.entities.Brand;

public interface BrandService {

	List<Brand> getAllBrands();
	
	boolean addBrand(Brand brand);
	
	boolean changeBrand(Brand brand);

	Brand getBrandById(int id);

	void removeBrand(Brand brand);
	
}
