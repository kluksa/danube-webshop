/**
 * 
 */
package com.ag04.danubewebshop.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ag04.danubewebshop.domain.ShoppingBasket;
import com.ag04.danubewebshop.domain.User;

/**
 * @author Lukša Kraljević, Srce
 *
 */
public interface ShoppingBasketService {
   
   public void addWithItemId(Long itemId, User user);

   public void removeById(Long id, User user);
   
   public Page<ShoppingBasket> findAllByUser(User user, Pageable pageable);
   

}
