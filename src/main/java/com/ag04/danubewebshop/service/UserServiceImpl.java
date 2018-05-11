/**
 * 
 */
package com.ag04.danubewebshop.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.ag04.danubewebshop.domain.User;
import com.ag04.danubewebshop.repository.UserRepository;

/**
 * @author Lukša Kraljević, Srce
 *
 */

@Service
public class UserServiceImpl implements UserService {

   private final UserRepository userRepository;

   public UserServiceImpl(UserRepository userRepository) {
      this.userRepository = userRepository;
   }
   
   @Override
   public User findByUsername(String username) {
      List<User> users = userRepository.findByUsername(username);
      if ( users.size() > 0 ) {
         return users.get(0);
      } else {
         return null;
      }
   }

}
