/**
 * 
 */
package com.ag04.danubewebshop.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ag04.danubewebshop.domain.Item;

/**
 * @author Lukša Kraljević, Srce
 *
 */

public interface ItemService {
   
   public void addItem(Item item);
   
   public void removeItem(Item item);
   
   public List<Item> findAllItems();
   
   public Page<Item> findAllPageable(Pageable pageable);

}
