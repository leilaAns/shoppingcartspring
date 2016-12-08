package com.alithya.shoppingcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.alithya.shoppingcard.service.ItemService;

@Controller
@RequestMapping("/showOneItem")
public class ShowOneItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping(value = "/{item}")
	public String showItem(Model model, @PathVariable int item) {
		model.addAttribute("item", itemService.find(item));
		return "showOneItem";
	}

	@RequestMapping(value = "/{item}", method = RequestMethod.POST)
	public String editAndSaveItem(@RequestParam String action, @PathVariable int item, @RequestParam int Id,
			@RequestParam String name, @RequestParam String type, @RequestParam String des) {

		if (action.equals("edit")) {
			itemService.editItem(item, itemService.createOneItem(Id, name, type, des));

		} else {
			itemService.deleteItem(item);
		}
		return "redirect:/adminShowAllItems";
	}

}
