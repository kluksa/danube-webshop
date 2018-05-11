/**
 * 
 */
package com.ag04.danubewebshop.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ag04.danubewebshop.domain.Item;

/**
 * @author Lukša Kraljević, Srce
 *
 */
@Repository
public interface ItemRepository extends PagingAndSortingRepository<Item, Long> {

}
