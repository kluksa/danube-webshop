package com.ag04.danubewebshop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ag04.danubewebshop.domain.ProductCategory;
import com.ag04.danubewebshop.repository.ItemRepository;
import com.ag04.danubewebshop.repository.ProductCategoryRepository;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

   @Autowired
	private ProductCategoryRepository productCategoryRepository;

   @Cacheable(value="product_categories")
	@Override
	public List<ProductCategory> findAll() {
		List<ProductCategory> products = new ArrayList<>();
		productCategoryRepository.findAll().forEach(products::add);
		return products;
	}

   /* (non-Javadoc)
    * @see com.ag04.danubewebshop.service.ProductCategoryService#findById(java.lang.Integer)
    */
   @Override
   public Optional<ProductCategory> findById(Long id) {
      return productCategoryRepository.findById(id);
   }

   /* (non-Javadoc)
    * @see com.ag04.danubewebshop.service.ProductCategoryService#findAllUsed()
    */
   @Override
   public List<ProductCategory> findAllUsed() {
      return productCategoryRepository.findAllUsed();
   }

}
