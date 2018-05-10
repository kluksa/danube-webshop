/**
 * 
 */
package hr.srce.isvu.restpreglednik.repository;

import hr.srce.isvu.restpreglednik.domain.User;

/**
 * @author Lukša Kraljević, Srce
 *
 */
public interface UserRepository {
   
   public User findByUsername(String username);

}
