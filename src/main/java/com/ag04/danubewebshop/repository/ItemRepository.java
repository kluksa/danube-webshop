/**
 * 
 */
package com.ag04.danubewebshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ag04.danubewebshop.domain.Item;

/**
 * @author Lukša Kraljević, Srce
 *
 */
@Repository
public interface ItemRepository extends PagingAndSortingRepository<Item, Long> {
	
	
	public List<Item> findAll();
	
//	@Query(value = "SELECT * FROM tbl_item p WHERE category_id = ?2 AND (name LIKE %?1% OR description LIKE %?1%)",
//	         countQuery = "SELECT count(*) FROM tbl_item WHERE category_id = ?2 AND ( name LIKE %?1%  OR description LIKE %?1%)",
//	         nativeQuery = true)
	@Query("SELECT i FROM Item i WHERE i.category.id = :categoryId AND (lower(i.name) LIKE lower(concat('%', :string,'%')) OR lower(i.description) LIKE lower(concat('%', :string,'%')))")
	public List<Item> findByNameIgnoreCaseContainingOrDescriptionIgnoreCaseContainingForCategory(@Param("string") String string, @Param("categoryId") Long categoryId);

	public List<Item> findByCategoryId(Long categoryId);

	public List<Item> findByNameIgnoreCaseContainingOrDescriptionIgnoreCaseContaining(String name, String description);

}
