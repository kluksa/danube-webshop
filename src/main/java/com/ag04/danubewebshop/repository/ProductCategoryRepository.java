package com.ag04.danubewebshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ag04.danubewebshop.domain.ProductCategory;


@Repository
public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Long>{

}
