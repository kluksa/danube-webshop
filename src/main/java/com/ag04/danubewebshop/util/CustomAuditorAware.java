/**
 * 
 */
package com.ag04.danubewebshop.util;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Lukša Kraljević, Srce
 *
 */
public class CustomAuditorAware implements AuditorAware<String> {

   @Override
   public Optional<String> getCurrentAuditor() {
       String loggedName = SecurityContextHolder.getContext().getAuthentication().getName();
       return Optional.of(loggedName);
   }
   
}
