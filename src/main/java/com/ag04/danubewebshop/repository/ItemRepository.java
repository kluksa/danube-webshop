/**
 * 
 */
package com.ag04.danubewebshop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ag04.danubewebshop.domain.Item;

/**
 * @author Lukša Kraljević, Srce
 *
 */
@Repository
public interface ItemRepository extends PagingAndSortingRepository<Item, Long> {
	public Page<Item> findByNameIgnoreCaseContainingOrDescriptionIgnoreCaseContaining(String name, String description, Pageable page);
	
	@Query(value = "SELECT * FROM tbl_item p WHERE category_id = ?2 AND (name LIKE %?1% OR description LIKE %?1%)",
	         countQuery = "SELECT count(*) FROM tbl_item WHERE category_id = ?2 AND ( name LIKE %?1%  OR description LIKE %?1%)",
	         nativeQuery = true)
	public Page<Item> findByNameOrDescriptionForCategory(String string, Long categoryId, Pageable page);

	@Query(value = "SELECT * FROM tbl_item p WHERE name LIKE %?1% OR description LIKE %?1%",
            countQuery = "SELECT count(*) FROM tbl_item WHERE name LIKE %?1%  OR description LIKE %?1%",
            nativeQuery = true)
   public Page<Item> findByNameOrDescription(String string,  Pageable page);

}
