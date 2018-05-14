/**
 * 
 */
package com.ag04.danubewebshop.web;

import java.security.Principal;
import java.util.List;
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
import com.ag04.danubewebshop.domain.ProductCategory;
import com.ag04.danubewebshop.service.ItemService;
import com.ag04.danubewebshop.service.ProductCategoryService;
import com.ag04.danubewebshop.service.UserService;

/**
 * @author Lukša Kraljević, Srce
 *
 */
@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	@Autowired
	private ProductCategoryService productCategoryService;
	
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public ModelAndView itemList(
			@RequestParam("searchCriteria") Optional<Long> categoryId,
			@RequestParam("searchString") Optional<String> searchString,
			@RequestParam("all") Optional<String> all
			) {
		ModelAndView modelAndView = new ModelAndView("user/items");

		List<Item> items = null;
		if ( ! all.isPresent() && searchString.isPresent() && !searchString.get().isEmpty()) {
		   if ( categoryId.isPresent()) {
		      modelAndView.addObject("searchCriteria", categoryId.get());
		      items = itemService.findByNameOrDescriptionAndCategoryId(searchString.get(), categoryId.get());
		   } else  {
			      items = itemService.findByNameOrDescription(searchString.get());
		   }
	      modelAndView.addObject("searchString", searchString.get());
	      
		} else {
			   items = itemService.findAll();
		}
		
		modelAndView.addObject("productCategories", productCategoryService.findAllUsed());
		modelAndView.addObject("items", items);
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
//		item.setAuthor(userService.findByUsername(principal.getName()).get());
	   model.addAttribute("productCategories",  productCategoryService.findAll());
		model.addAttribute("writeable", true);
		model.addAttribute("item", item);
		return "layout/item_details :: modalContents";
	}
	

	@RolesAllowed("ROLE_ADMIN")
	@PostMapping("/item/")
	public String addItemP(String name, Long categoryId, String description, String pictureUrl ) {
		Item item = new Item();
		item.setName(name);
		Optional<ProductCategory> category = productCategoryService.findById(categoryId);
		item.setCategory(category.get());
		item.setDescription(description);
		item.setPictureUrl(pictureUrl);
		itemService.addItem(item);
		return "redirect:/";
	}


}
