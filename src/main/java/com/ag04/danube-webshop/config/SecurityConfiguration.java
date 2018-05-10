/**
 * 
 */
package com.ag04.danube-webshop.config;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Lukša Kraljević, Srce
 */
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

   @Override
   protected void configure(HttpSecurity http) throws Exception {

      http.authorizeRequests().requestMatchers(EndpointRequest.toAnyEndpoint()).hasAnyRole("ADMIN")
               .antMatchers("/libs/*.html").hasAnyRole("ADMIN").antMatchers("/**").permitAll()
               .anyRequest().authenticated().and().httpBasic();
   }

}
