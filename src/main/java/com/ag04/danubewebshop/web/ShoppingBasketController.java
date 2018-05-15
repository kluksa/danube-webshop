/**
 * 
 */
package com.ag04.danubewebshop.web;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ag04.danubewebshop.domain.ShoppingBasket;
import com.ag04.danubewebshop.domain.User;
import com.ag04.danubewebshop.service.ShoppingBasketService;
import com.ag04.danubewebshop.service.UserService;

@Controller
@RequestMapping(value = "/basket")
public class ShoppingBasketController {
	
	@Autowired
	private ShoppingBasketService shoppingBasketService;
	@Autowired
	private UserService userService;

	@RequestMapping("add")
	public ResponseEntity<Object> addItemToBasket(Principal principal, @RequestParam("id") Long itemId) {
		User user = userService.findByUsername(principal.getName()).get();
		shoppingBasketService.addWithItemId(itemId, user);
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}
	
	@GetMapping("remove")
	public String removeItemFromBasket(Principal principal, @RequestParam("id") Long id) {
		User user = userService.findByUsername(principal.getName()).get();
		shoppingBasketService.removeById(id, user);
		return "redirect:/basket";
	}
	
	@GetMapping
	public ModelAndView showBasket(Principal principal) {
		User user = userService.findByUsername(principal.getName()).get();
		List<ShoppingBasket> items = shoppingBasketService.findAllByUser(user);
		ModelAndView modelAndView = new ModelAndView("user/basket");
		modelAndView.addObject("items", items);
		return modelAndView;
		
	}
	
}
