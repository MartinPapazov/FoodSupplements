package com.fs.store.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fs.store.constants.UrlConstants;
import com.fs.store.entities.Brand;
import com.fs.store.services.brand.BrandService;

@Controller
public class BrandController {

	@Autowired
	private BrandService brandService;

	@RequestMapping(value = UrlConstants.ALL_BRANDS, method = RequestMethod.GET)
	public @ResponseBody List<Brand> getAllCategorys() {
		List<Brand> brands = brandService.getAllBrands();
		
		return brands;
	}

	@RequestMapping(value = UrlConstants.ADD_BRAND, method = RequestMethod.POST)
	public @ResponseBody Brand addCategory(@RequestParam("name") String name,
			@RequestParam("description") String description, @RequestParam("myimage") MultipartFile file) {
		
		Brand brand = new Brand();
		brand.setName(name);
		brand.setDescription(description);
		if (file != null) {
			byte[] image;
			try {
				image = file.getBytes();
				brand.setImage(image);
			} catch (IOException e) {
				// TODO: Log it
			}
		}
		
		boolean added = brandService.addBrand(brand);
		if (added) {
			return brand;
		}

		return null;
	}
	
	@RequestMapping(value = UrlConstants.GET_BRAND_BY_ID, method = RequestMethod.POST)
	public @ResponseBody Brand getBrandById(@RequestBody Brand brand) {
		Brand brandById = brandService.getBrandById(brand.getId());

		return brandById;
	}
	
	@RequestMapping(value = UrlConstants.REMOVE_BRAND, method = RequestMethod.POST)
	public @ResponseBody Brand removeBrand(@RequestBody Brand brand) {
		brandService.removeBrand(brand);
		return brand;
	}
}
