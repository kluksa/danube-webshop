/**
 * 
 */
package com.ag04.danubewebshop.service;

import java.util.Optional;

import com.ag04.danubewebshop.domain.User;

public interface UserService {
   
   public Optional<User> findByUsername(String username);

}
