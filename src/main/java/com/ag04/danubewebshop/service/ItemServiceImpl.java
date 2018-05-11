/**
 * 
 */
package com.ag04.danubewebshop.service;

import java.util.ArrayList;
import java.util.List;

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
public class ItemServiceImpl implements ItemService{
   
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
   public List<Item> findAllItems() {
      List<Item> lista = new ArrayList<>();
      lista.add(new Item(1, "Prvo ime", new ProductCategory(1,"Neka kategorija"), "Opis Prvo", "Url Prvo"));
      lista.add(new Item(2, "Drugo ime", new ProductCategory(1,"Druga kategorija"), "Opis Drugo", "Url Drugo"));
      lista.add(new Item(3, "Trece ime", new ProductCategory(1,"Treca kategorija"), "Opis Trece", "Url Trece"));
      lista.add(new Item(4, "Cetvrto ime", new ProductCategory(1,"Neka kategorija"), "Opis Cetvrto", "Url Cetvrto"));
      lista.add(new Item(5, "Peto ime", new ProductCategory(1,"Druga kategorija"), "Opis Peto", "Url Peto"));
      lista.add(new Item(6, "Sesto ime", new ProductCategory(1,"Neka kategorija"), "Opis Sesto", "Url Sesto"));
      lista.add(new Item(7, "Sedmo ime", new ProductCategory(1,"Neka kategorija"), "Opis Sedmo", "Url Sedmo"));
      lista.add(new Item(8, "Osmo ime", new ProductCategory(1,"Druga kategorija"), "Opis Osmo", "Url Osmo"));
      lista.add(new Item(9, "Deveto ime", new ProductCategory(1,"Neka kategorija"), "Opis Deveto", "Url Deveto"));
      lista.add(new Item(10, "Deseto ime", new ProductCategory(1,"Treca kategorija"), "Opis Deseto", "Url Deseto"));
      return null;
   }

   @Override
   public Page<Item> findAllPageable(Pageable pageable) {
      return itemRepository.findAll(pageable);
   }

}
