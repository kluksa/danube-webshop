package com.ag04.danubewebshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ag04.danubewebshop.domain.ProductCategory;
import com.ag04.danubewebshop.repository.ItemRepository;
import com.ag04.danubewebshop.repository.ProductCategoryRepository;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

	private final ProductCategoryRepository productCategoryRepository;

	public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository) {
		this.productCategoryRepository = productCategoryRepository;
	}

	@Override
	public List<ProductCategory> findAll() {
		List<ProductCategory> products = new ArrayList<>();
		productCategoryRepository.findAll().forEach(products::add);
		return products;
	}

}
