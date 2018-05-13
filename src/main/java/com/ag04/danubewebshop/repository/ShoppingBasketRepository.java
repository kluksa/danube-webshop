/**
 * 
 */
package com.ag04.danubewebshop.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ag04.danubewebshop.domain.ShoppingBasket;
import com.ag04.danubewebshop.domain.User;

/**
 * @author Lukša Kraljević, Srce
 *
 */
@Repository
public interface ShoppingBasketRepository extends CrudRepository<ShoppingBasket, Long>{

	List<ShoppingBasket> findByUser(User user);

}
