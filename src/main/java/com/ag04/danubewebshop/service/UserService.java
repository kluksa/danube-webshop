/**
 * 
 */
package com.ag04.danubewebshop.service;

import com.ag04.danubewebshop.domain.User;

/**
 * @author Lukša Kraljević, Srce
 *
 */
public interface UserService {
   
   public User findByUsername(String username);

}
