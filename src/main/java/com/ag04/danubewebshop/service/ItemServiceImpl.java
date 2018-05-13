/**
 * 
 */
package com.ag04.danubewebshop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
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
	public Page<Item> findAllPageable(Pageable pageable) {
		return itemRepository.findAll(pageable);
	}

	@Override
	public Optional<Item> findById(Long id) {
		return itemRepository.findById(id);
	}

}
