/**
 * 
 */
package com.ag04.danubewebshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ag04.danubewebshop.domain.Item;
import com.ag04.danubewebshop.repository.ItemRepository;

/**
 * @author Lukša Kraljević, Srce
 *
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Override
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
	public List<Item> findByNameOrDescriptionAndCategoryId(String string, Long categoryId) {
		return itemRepository.findByNameIgnoreCaseContainingOrDescriptionIgnoreCaseContainingForCategory(string, categoryId);
	}

	@Override
	public List<Item> findByCategoryId(Long categoryId) {
		return itemRepository.findByCategoryId(categoryId);
	}

}
