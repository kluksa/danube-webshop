package com.ag04.danubewebshop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ag04.danubewebshop.domain.ProductCategory;


@Repository
public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Long>{
   public Optional<ProductCategory> findById(Long id);
   
   @Query("SELECT DISTINCT i.category FROM Item i")
   public List<ProductCategory> findAllUsed();

}
