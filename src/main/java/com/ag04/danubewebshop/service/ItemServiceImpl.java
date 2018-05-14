/**
 * 
 */
package com.ag04.danubewebshop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ag04.danubewebshop.domain.Item;
import com.ag04.danubewebshop.domain.ProductCategory;
import com.ag04.danubewebshop.repository.ItemRepository;

/**
 * @author Lukša Kraljević, Srce
 *
 */
@Service
public class ItemServiceImpl implements ItemService {

	private final ItemRepository itemRepository;

	public ItemServiceImpl(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@Override
	public void addItem(Item item) {
		itemRepository.save(item);
	}

	@Override
	public void removeItem(Item item) {
		itemRepository.delete(item);
	}

	@Override
	@Cacheable(value="items", key= "#page")
	public Page<Item> findAllPageable(Pageable page) {
		return itemRepository.findAll(page);
	}

	@Override
	@Cacheable(value="items", key= "#id")
	public Optional<Item> findById(Long id) {
		return itemRepository.findById(id);
	}

   /* (non-Javadoc)
    * @see com.ag04.danubewebshop.service.ItemService#findByProductCategoryLikePageable(java.lang.String, org.springframework.data.domain.Pageable)
    */
   @Override
   @Cacheable(value="items", key= "{#description, #page}")
   public Page<Item> findByNameOrDescription(String description, Pageable page) {
      return itemRepository.findByNameIgnoreCaseContainingOrDescriptionIgnoreCaseContaining(description, description, page);
   }

   /* (non-Javadoc)
    * @see com.ag04.danubewebshop.service.ItemService#findByNameOrDescriptionAndCategoryPageable(java.lang.String, java.lang.Integer, org.springframework.data.domain.PageRequest)
    */
   @Override
   public Page<Item> findByNameOrDescriptionAndCategoryPageable(String string, Long categoryId, PageRequest page) {
      return itemRepository.findByNameOrDescriptionForCategory(string, categoryId, page);
   }

}
