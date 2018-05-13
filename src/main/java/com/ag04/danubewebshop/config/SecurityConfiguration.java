/**
 * 
 */
package com.ag04.danubewebshop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ag04.danubewebshop.domain.User;
import com.ag04.danubewebshop.repository.UserRepository;
import com.ag04.danubewebshop.service.UserService;

/**
 * @author Lukša Kraljević, Srce
 */
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	@Qualifier("userDetailsService")
	UserDetailsService userDetailsService;

	@Autowired
	UserService userService;
	@Autowired
	UserRepository repository;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
				.antMatchers("/css/**").permitAll()
				.antMatchers("/lib/**").permitAll()
				.antMatchers("/js/**").permitAll()
				.anyRequest().authenticated()
			.and().authorizeRequests().antMatchers("/console/**").permitAll()
			.and()
				.formLogin().loginPage("/login").permitAll()
					.failureUrl("/login?error=true")
					.defaultSuccessUrl("/")
					.usernameParameter("username")
					.passwordParameter("password")
			.and()
				.logout().invalidateHttpSession(true)
				.logoutSuccessUrl("/login?logout=true")
			.and().csrf()
			.and().exceptionHandling().accessDeniedPage("/403");
	}
	

	@Bean
	public DaoAuthenticationProvider authProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder  auth) throws  Exception {
		auth.authenticationProvider(authProvider());
	}

}
