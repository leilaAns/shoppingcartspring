package com.alithya.shoppingcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alithya.shoppingcard.entity.Item;
import com.alithya.shoppingcard.service.ItemService;

@Controller
@RequestMapping("/showItem")
public class ShowItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping(value = "/{itemId}")
	public String showItem(Model model, @PathVariable int itemId) {
		model.addAttribute("item", itemService.find(itemId));
		return "showItem";
	}

	@RequestMapping(value = "/{itemId}", method = RequestMethod.POST)
	public String editOrDeleteItem(@RequestParam String action,@ModelAttribute Item item) {

		if (action.equals("edit")) {
			itemService.editItem(item);

		} else {
			itemService.deleteItem(item.getId());
		}
		return "redirect:/adminShowAllItems";
	}

}
