/**
 * 
 */
package com.ag04.danubewebshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Lukša Kraljević, Srce
 *
 */
@Controller
public class ItemController {
   @GetMapping( "/" )
   public String itemList() {
      return "user/items";
   }
   
   @GetMapping( "/admin/new_item" )
   public String newItem() {
      return "admin/item";
   }
   
   @PostMapping( "/admin/new_item")
   public String addItem(Model model) {
      return "redirect:user/item";
      
   }


}
