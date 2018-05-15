/**
 * 
 */
package com.ag04.danubewebshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ag04.danubewebshop.domain.User;
import com.ag04.danubewebshop.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

   @Autowired
   private UserRepository userRepository;

   @Cacheable(value="users", key="#username")
   @Override
   public Optional<User> findByUsername(String username) {
      List<User> users = userRepository.findByUsername(username);
      if ( users.size() > 0 ) {
         return Optional.of(users.get(0));
      } else {
         return Optional.empty();
      }
   }

}
