package com.alithya.shoppingcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alithya.shoppingcard.service.ItemService;

@Controller
public class AdminShowAllItemsController {

	@Autowired
	private ItemService itemService;

	@RequestMapping("/adminShowAllItems")
	public String showAllItem(Model model) {
		model.addAttribute("allItems", itemService.findAll());
		return "adminShowAllItems";
	}
}
