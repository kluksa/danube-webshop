/**
 * 
 */
package com.ag04.danubewebshop.web;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ag04.danubewebshop.domain.Item;
import com.ag04.danubewebshop.service.ItemService;
import com.ag04.danubewebshop.service.ProductCategoryService;

@Controller
public class AddItemController {
   @Autowired
   private ItemService itemService;
   @Autowired
   private ProductCategoryService productCategoryService;
   
   @InitBinder
   protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
       SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy");   
       dateFormat.setLenient(false);
       binder.registerCustomEditor(Date.class, null,  new CustomDateEditor(dateFormat, true));
   }
   
   @GetMapping("/item/new")
   @RolesAllowed("ROLE_ADMIN")
   public String newItemPopup( ModelMap model, Principal principal) {
      Item item = new Item();
      item.setCreatedBy(principal.getName());
      item.setCreatedAt(new Date());
      item.setId(itemService.getMaxId()+1);
      model.addAttribute("productCategories",  productCategoryService.findAll());
      model.addAttribute("item", item);
      return "admin/add_item";
   }
   

   @RolesAllowed("ROLE_ADMIN")
   @PostMapping("/item/new")
      public String addItemP(@Valid @ModelAttribute("item") Item item,   BindingResult result, Model model, Principal principal) {
      
	   if ( result.hasErrors()) {
		   return "admin/add_item";
	   }
      if ( !principal.getName().equals(item.getCreatedBy())) {
         item.setCreatedBy(principal.getName());
         model.addAttribute("productCategories",  productCategoryService.findAll());
         model.addAttribute("item", item);
         return "admin/add_item";
      }
      
      if ( !item.getId().equals(itemService.getMaxId()+1)) {
         item.setId(itemService.getMaxId()+1);
         model.addAttribute("productCategories",  productCategoryService.findAll());
         model.addAttribute("item", item);
         return "admin/add_item";
         
      }
      itemService.addItem(item);
      return "redirect:/";
   }


}
