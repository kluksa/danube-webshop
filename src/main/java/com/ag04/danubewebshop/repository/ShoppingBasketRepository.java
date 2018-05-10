/**
 * 
 */
package com.ag04.danubewebshop.repository;

import java.util.List;

import com.ag04.danubewebshop.domain.Item;

/**
 * @author Lukša Kraljević, Srce
 *
 */
public interface ShoppingBasketRepository {
   
   public void addToBasket(Item item);
   
   public List<Item> getAllItems();
   
   public void removeItem(Item item);

}
