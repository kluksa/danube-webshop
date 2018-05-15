/**
 * 
 */
package com.ag04.danubewebshop.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ag04.danubewebshop.domain.ShoppingBasket;
import com.ag04.danubewebshop.domain.User;

@Repository
public interface ShoppingBasketRepository extends PagingAndSortingRepository<ShoppingBasket, Long>{

	List<ShoppingBasket> findByUser(User user);

}
