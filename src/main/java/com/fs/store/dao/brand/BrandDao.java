package com.fs.store.dao.brand;

import java.util.List;

import com.fs.store.entities.Brand;

public interface BrandDao {

	List<Brand> getAllBrands();
	
	boolean addBrand(Brand brand);

	boolean changeBrand(Brand brand);
	
	Brand getBrandById(int id);

	boolean removeBrand(Brand brand);
}
