package com.ag04.danubewebshop;

import java.util.Locale;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.ag04.danubewebshop.util.CustomAuditorAware;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories
@EnableJpaAuditing(auditorAwareRef="auditorProvider")
public class DanubeWebshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(DanubeWebshopApplication.class, args);
	}
	
	@Bean
	public LocaleResolver localeResolver() {
	    SessionLocaleResolver slr = new SessionLocaleResolver();
	    slr.setDefaultLocale(Locale.US);
	    return slr;
	}
	 @Bean
    public AuditorAware<String> auditorProvider(){
        return new CustomAuditorAware();
	 }
	
}
