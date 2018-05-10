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
public interface ItemRepository {
   
   public void addItem(Item item);
   
   public List<Item> findAllItems();

}
