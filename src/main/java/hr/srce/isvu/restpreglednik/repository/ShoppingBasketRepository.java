/**
 * 
 */
package hr.srce.isvu.restpreglednik.repository;

import java.util.List;

import hr.srce.isvu.restpreglednik.domain.Item;

/**
 * @author Lukša Kraljević, Srce
 *
 */
public interface ShoppingBasketRepository {
   
   public void addToBasket(Item item);
   
   public List<Item> getAllItems();
   
   public void removeItem(Item item);

}
