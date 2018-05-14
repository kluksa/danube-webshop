package com.ag04.danubewebshop.service;

import java.util.List;
import java.util.Optional;

import com.ag04.danubewebshop.domain.ProductCategory;

public interface ProductCategoryService {
	public List<ProductCategory> findAll();
	
	public Optional<ProductCategory> findById(Long id);
	
	public List<ProductCategory> findAllUsed();

}
