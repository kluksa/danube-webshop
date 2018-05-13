/**
 * 
 */
package com.ag04.danubewebshop.service;

import java.util.Optional;

import com.ag04.danubewebshop.domain.User;

/**
 * @author Lukša Kraljević, Srce
 *
 */
public interface UserService {
   
   public Optional<User> findByUsername(String username);

}
