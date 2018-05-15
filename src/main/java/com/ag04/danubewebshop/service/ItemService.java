/**
 * 
 */
package com.ag04.danubewebshop.service;

import java.util.List;
import java.util.Optional;


import com.ag04.danubewebshop.domain.Item;


public interface ItemService {
   
   public void addItem(Item item);
   
   public Optional<Item> findById(Long id);

   public List<Item> findAll();
   
   public List<Item> findByCategoryId(Long categoryId);
   
   public List<Item> findByNameOrDescription(String name);

   public List<Item> findByNameOrDescriptionAndCategoryId(String string, Long categoryId);
   
   public Long getMaxId();

}
