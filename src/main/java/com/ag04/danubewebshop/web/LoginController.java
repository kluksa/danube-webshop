/**
 * 
 */
package com.ag04.danubewebshop.web;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Lukša Kraljević, Srce
 *
 */
@Controller
public class LoginController {
   @GetMapping( "/login" )
   public ModelAndView login(@RequestParam(name="logout", required=false) String logout, Error error) {
	   ModelAndView modelAndView = new ModelAndView("login");
	   modelAndView.addObject("logout", logout);
	   return modelAndView;
   }

}
