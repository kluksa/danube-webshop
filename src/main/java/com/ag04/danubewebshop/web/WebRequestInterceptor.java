/**
 * 
 */
package com.ag04.danubewebshop.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.ContentCachingRequestWrapper;

/**
 * @author Lukša Kraljević, Srce
 */
@Component
public class WebRequestInterceptor extends HandlerInterceptorAdapter {
   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) {

      HttpServletRequest requestCacheWrapperObject = new ContentCachingRequestWrapper(request);
      requestCacheWrapperObject.getParameterMap();
      return true;
   }

}
