/**
 * 
 */
package com.ag04.danubewebshop.config;

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
               .antMatchers("/admin", "/h2_console/**").hasRole("ADMIN")
               .anyRequest().authenticated().and().httpBasic();
      
      http.csrf().disable();
      http.headers().frameOptions().disable();
   }

//   http://www.mkyong.com/spring-security/spring-security-hibernate-annotation-example/
//   @Autowired
//   @Qualifier("userDetailsService")
//   UserDetailsService userDetailsService;
//
//   @Autowired
//   public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//      auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//   }
//
//   @Override
//   protected void configure(HttpSecurity http) throws Exception {
//
//       http.authorizeRequests().antMatchers("/admin/**")
//      .access("hasRole('ROLE_ADMIN')").and().formLogin()
//      .loginPage("/login").failureUrl("/login?error")
//      .usernameParameter("username")
//      .passwordParameter("password")
//      .and().logout().logoutSuccessUrl("/login?logout")
//      .and().csrf()
//      .and().exceptionHandling().accessDeniedPage("/403");
//   }
//   
//   @Bean
//   public PasswordEncoder passwordEncoder(){
//      PasswordEncoder encoder = new BCryptPasswordEncoder();
//      return encoder;
//   }
   
}
