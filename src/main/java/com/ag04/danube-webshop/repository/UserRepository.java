/**
 * 
 */
package com.ag04.danube-webshop.repository;

import com.ag04.danube-webshop.domain.User;

/**
 * @author Lukša Kraljević, Srce
 *
 */
public interface UserRepository {
   
   public User findByUsername(String username);

}
