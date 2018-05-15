/**
 * 
 */
package com.ag04.danubewebshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ag04.danubewebshop.domain.Item;
import com.ag04.danubewebshop.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Override
	@CacheEvict("items")
	public void addItem(Item item) {
		itemRepository.save(item);
	}

	@Override
	@Cacheable(value = "items", key = "#id")
	public Optional<Item> findById(Long id) {
		return itemRepository.findById(id);
	}

	@Override
	@Cacheable(value = "items")
	public List<Item> findAll() {
		return itemRepository.findAll();
	}

	@Override
	@Cacheable(value = "items", key = "{#description}")
	public List<Item> findByNameOrDescription(String description) {
		return itemRepository.findByNameIgnoreCaseContainingOrDescriptionIgnoreCaseContaining(description, description);
	}

	@Override
	@Cacheable(value = "items", key = "{#string, #categoryId}")
	public List<Item> findByNameOrDescriptionAndCategoryId(String string, Long categoryId) {
		return itemRepository.findByNameIgnoreCaseContainingOrDescriptionIgnoreCaseContainingForCategory(string, categoryId);
	}

	@Override
	@Cacheable(value = "items", key = "{#categoryId}")
	public List<Item> findByCategoryId(Long categoryId) {
		return itemRepository.findByCategoryId(categoryId);
	}

   /* (non-Javadoc)
    * @see com.ag04.danubewebshop.service.ItemService#findMaxId()
    */
   @Override
   public Long getMaxId() {
      return itemRepository.getMaxId();
   }

}
