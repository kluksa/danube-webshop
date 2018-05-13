/**
 * 
 */
package com.ag04.danubewebshop.web;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ag04.danubewebshop.domain.Item;
import com.ag04.danubewebshop.domain.Pager;
import com.ag04.danubewebshop.domain.ShoppingBasket;
import com.ag04.danubewebshop.domain.User;
import com.ag04.danubewebshop.service.ShoppingBasketService;
import com.ag04.danubewebshop.service.UserService;

/**
 * @author Lukša Kraljević, Srce
 *
 */
@Controller
@RequestMapping(value = "/basket")
public class ShoppingBasketController {
	private static final int BUTTONS_TO_SHOW = 5;
	private static final int INITIAL_PAGE = 0;
	private static final int INITIAL_PAGE_SIZE = 5;
	private static final int[] PAGE_SIZES = { 5, 10, 20 };
	
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
	public ModelAndView showBasket(@RequestParam("pageSize") Optional<Integer> pageSize,
			@RequestParam("page") Optional<Integer> page, Principal principal) {
		User user = userService.findByUsername(principal.getName()).get();
		
		int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
		int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

		Page<ShoppingBasket> items = shoppingBasketService.findAllByUser(user, PageRequest.of(evalPage, evalPageSize));
		Pager pager = new Pager(items.getTotalPages(), items.getNumber(), BUTTONS_TO_SHOW);

		ModelAndView modelAndView = new ModelAndView("user/basket");
		
		modelAndView.addObject("items", items);
		modelAndView.addObject("selectedPageSize", evalPageSize);
		modelAndView.addObject("pageSizes", PAGE_SIZES);
		modelAndView.addObject("pager", pager);
		return modelAndView;
		
	}
	
}
