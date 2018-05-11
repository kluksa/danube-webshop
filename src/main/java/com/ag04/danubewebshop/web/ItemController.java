/**
 * 
 */
package com.ag04.danubewebshop.web;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ag04.danubewebshop.domain.Item;
import com.ag04.danubewebshop.domain.Pager;
import com.ag04.danubewebshop.service.ItemService;

/**
 * @author Lukša Kraljević, Srce
 *
 */
@Controller
public class ItemController {
   private static final int BUTTONS_TO_SHOW = 5;
   private static final int INITIAL_PAGE = 0;
   private static final int INITIAL_PAGE_SIZE = 5;
   private static final int[] PAGE_SIZES = {5, 10, 20};
   
   private final ItemService itemService;

   public ItemController(ItemService itemService) {
      this.itemService = itemService;
   }
   
   @GetMapping("/")
   public ModelAndView itemList(@RequestParam("pageSize") Optional<Integer> pageSize,
            @RequestParam("page") Optional<Integer> page) {
      ModelAndView modelAndView = new ModelAndView("user/items");

      // Evaluate page size. If requested parameter is null, return initial
      // page size
      int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
      // Evaluate page. If requested parameter is null or less than 0 (to
      // prevent exception), return initial size. Otherwise, return value of
      // param. decreased by 1.
      int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

      Page<Item> items = itemService.findAllPageable(PageRequest.of(evalPage, evalPageSize));
      Pager pager = new Pager(items.getTotalPages(), items.getNumber(), BUTTONS_TO_SHOW);

      modelAndView.addObject("items", items);
      modelAndView.addObject("selectedPageSize", evalPageSize);
      modelAndView.addObject("pageSizes", PAGE_SIZES);
      modelAndView.addObject("pager", pager);
      return modelAndView;
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
