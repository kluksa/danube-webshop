/**
 * 
 */
package com.ag04.danubewebshop.service;

import java.util.List;

import com.ag04.danubewebshop.domain.ShoppingBasket;
import com.ag04.danubewebshop.domain.User;

public interface ShoppingBasketService {
   
   public void addWithItemId(Long itemId, User user);

   public void removeById(Long id, User user);
   
   public List<ShoppingBasket> findAllByUser(User user);
   

}
