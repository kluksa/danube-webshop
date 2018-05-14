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
   
   public void removeItem(Item item);
   
   public Page<Item> findAllPageable(Pageable pageable);
   
   public Optional<Item> findById(Long id);
   
   public Page<Item> findByNameOrDescription(String name, Pageable pageable);

   public Page<Item> findByNameOrDescriptionAndCategoryPageable(String string, Long categoryId, PageRequest page);

}
