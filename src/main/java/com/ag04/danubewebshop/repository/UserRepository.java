/**
 * 
 */
package com.ag04.danubewebshop.repository;

import com.ag04.danubewebshop.domain.User;

/**
 * @author Lukša Kraljević, Srce
 *
 */
public interface UserRepository {
   
   public User findByUsername(String username);

}
