/**
 * 
 */
package com.ag04.danubewebshop.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ag04.danubewebshop.domain.Role;
import com.ag04.danubewebshop.domain.User;

@Service("userDetailsService")
public class DanubeUserDetailService implements UserDetailsService {

   private final UserService userService;

   public DanubeUserDetailService(UserService userService) {
      this.userService = userService;
   }

   @Transactional(readOnly = true)
   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      Optional<User> user = userService.findByUsername(username);
      if ( ! user.isPresent() ) throw new UsernameNotFoundException(username);
      Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
      for (Role role : user.get().getRoles()){
          grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
      }

      return new org.springframework.security.core.userdetails.User(user.get().getUsername(), user.get().getPassword(), grantedAuthorities);

   }

   private List<GrantedAuthority> buildUserAuthority(Set<Role> userRoles) {

      List<GrantedAuthority> listAuths = new ArrayList<GrantedAuthority>();

      // Build user's authorities
      for (Role userRole : userRoles) {
         listAuths.add(new SimpleGrantedAuthority(userRole.getName()));
      }

      return listAuths;
   }

   private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user,
            List<GrantedAuthority> authorities) {
      return new org.springframework.security.core.userdetails.User(user.getUsername(),
               user.getPassword(), user.isEnabled(), true, true, true, authorities);
   }
}
