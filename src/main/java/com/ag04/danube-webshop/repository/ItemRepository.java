/**
 * 
 */
package com.ag04.danube-webshop.repository;

import java.util.List;

import com.ag04.danube-webshop.domain.Item;

/**
 * @author Lukša Kraljević, Srce
 *
 */
public interface ItemRepository {
   
   public void addItem(Item item);
   
   public List<Item> findAllItems();

}
