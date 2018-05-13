/**
 * 
 */
package com.ag04.danubewebshop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ag04.danubewebshop.domain.Item;
import com.ag04.danubewebshop.domain.ProductCategory;

/**
 * @author Lukša Kraljević, Srce
 *
 */
@Repository
public interface ItemRepository extends PagingAndSortingRepository<Item, Long> {
	public Page<Item> findByCategory(ProductCategory cat, Pageable page);
	public Page<Item> findByDescriptionLike(String description, Pageable page);

}
