package com.ag04.danubewebshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import com.ag04.danubewebshop.domain.Item;
import com.ag04.danubewebshop.domain.ShoppingBasket;
import com.ag04.danubewebshop.domain.User;
import com.ag04.danubewebshop.repository.ItemRepository;
import com.ag04.danubewebshop.repository.ShoppingBasketRepository;

@Service
public class ShoppingBasketServiceImpl implements ShoppingBasketService {

	@Autowired
	private ShoppingBasketRepository repo;

	@Autowired
	private ItemRepository itemRepo;

	@Override
	@CacheEvict("basket")
	public void addWithItemId(Long itemId, User user) {
		
		Optional<Item> item = itemRepo.findById(itemId);
		
		ShoppingBasket entry = new ShoppingBasket();
		entry.setItem(item.get());
		entry.setUser(user);
		repo.save(entry);
	}

	@Override
	@CacheEvict("basket")
	public void removeById(Long id, User user) {

		Optional<ShoppingBasket> entry = repo.findById(id);
		if (user.equals(entry.get().getUser())) {
			repo.delete(entry.get());
		} else {
			throw new AccessDeniedException("User has no rights");
		}
	}

	@Cacheable(value="basket", key= "{#user}")
	@Override
	public List<ShoppingBasket> findAllByUser(User user) {
		return repo.findByUser(user);
	}

}
