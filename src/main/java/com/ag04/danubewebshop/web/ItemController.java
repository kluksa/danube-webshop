/**
 * 
 */
package com.ag04.danubewebshop.web;

import java.security.Principal;
import java.util.Optional;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ag04.danubewebshop.domain.Item;
import com.ag04.danubewebshop.domain.Pager;
import com.ag04.danubewebshop.service.ItemService;
import com.ag04.danubewebshop.service.ProductCategoryService;
import com.ag04.danubewebshop.service.ShoppingBasketService;
import com.ag04.danubewebshop.service.UserService;

/**
 * @author Lukša Kraljević, Srce
 *
 */
@Controller
public class ItemController {
	private static final int BUTTONS_TO_SHOW = 5;
	private static final int INITIAL_PAGE = 0;
	private static final int INITIAL_PAGE_SIZE = 5;
	private static final int[] PAGE_SIZES = { 5, 10, 20 };

	@Autowired
	private ItemService itemService;
	@Autowired
	private ProductCategoryService productCategoryService;
	
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public ModelAndView itemList(@RequestParam("pageSize") Optional<Integer> pageSize,
			@RequestParam("page") Optional<Integer> page) {
		ModelAndView modelAndView = new ModelAndView("user/items");

		int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
		int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

		Page<Item> items = itemService.findAllPageable(PageRequest.of(evalPage, evalPageSize));
		Pager pager = new Pager(items.getTotalPages(), items.getNumber(), BUTTONS_TO_SHOW);

		modelAndView.addObject("productCategories", productCategoryService.findAll());
		modelAndView.addObject("items", items);
		modelAndView.addObject("selectedPageSize", evalPageSize);
		modelAndView.addObject("pageSizes", PAGE_SIZES);
		modelAndView.addObject("pager", pager);
		return modelAndView;
	}
	
	@RequestMapping("/item/{id}")
	public String item(@PathVariable("id") Long id, ModelMap model) {
		Optional<Item> item = itemService.findById(id);
		model.addAttribute("item", item.get());
		return "layout/item_details :: modalContents";
	}
	
	@GetMapping("/item/new")
	@RolesAllowed("ROLE_ADMIN")
	public String newItem( ModelMap model, Principal principal) {
		Item item = new Item();
		item.setAuthor(userService.findByUsername(principal.getName()).get());
		model.addAttribute("writeable", true);
		model.addAttribute("item", item);
		return "layout/item_details :: modalContents";
	}
	

	@RolesAllowed("ROLE_ADMIN")
	@PostMapping("/item/")
	public String addItemP(String name,  String description, String pictureUrl ) {
		
		Item item = new Item();
		item.setName(name);
		item.setDescription(description);
		item.setPictureUrl(pictureUrl);
		itemService.addItem(item);
		return "redirect:/";
	}


}
