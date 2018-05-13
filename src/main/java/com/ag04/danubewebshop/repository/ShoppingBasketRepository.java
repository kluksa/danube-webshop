/**
 * 
 */
package com.ag04.danubewebshop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ag04.danubewebshop.domain.ShoppingBasket;
import com.ag04.danubewebshop.domain.User;

/**
 * @author Lukša Kraljević, Srce
 *
 */
@Repository
public interface ShoppingBasketRepository extends PagingAndSortingRepository<ShoppingBasket, Long>{

	Page<ShoppingBasket> findByUser(User user, Pageable page);

}
