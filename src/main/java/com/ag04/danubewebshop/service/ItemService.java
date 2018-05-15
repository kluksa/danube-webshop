/**
 * 
 */
package com.ag04.danubewebshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.ag04.danubewebshop.domain.Item;

/**
 * @author Lukša Kraljević, Srce
 *
 */

public interface ItemService {
   
   public void addItem(Item item);
   
   public Optional<Item> findById(Long id);

   public List<Item> findAll();
   
   public List<Item> findByCategoryId(Long categoryId);
   
   public List<Item> findByNameOrDescription(String name);

   public List<Item> findByNameOrDescriptionAndCategoryId(String string, Long categoryId);
   
   public Long getMaxId();

}
