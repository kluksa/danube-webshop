/**
 * 
 */
package com.ag04.danubewebshop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ag04.danubewebshop.web.WebRequestInterceptor;

/**
 * @author Lukša Kraljević, Srce
 */
@Configuration
public class RequestAuditConfiguration implements WebMvcConfigurer {
   
   @Autowired
   private WebRequestInterceptor webRequestInterceptor;
   
   @Bean
   public CommonsRequestLoggingFilter logFilter() {
      CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
      filter.setIncludeQueryString(true);
      filter.setIncludePayload(true);
      filter.setMaxPayloadLength(10000);
      filter.setIncludeHeaders(true);
      filter.setAfterMessagePrefix("REQUEST DATA : ");
      return filter;
   }
   
   @Override
   public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(webRequestInterceptor)
         .addPathPatterns("/**/");
   }

}
