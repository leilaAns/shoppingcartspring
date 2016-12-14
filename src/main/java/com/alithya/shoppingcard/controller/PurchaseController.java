package com.alithya.shoppingcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alithya.shoppingcard.service.ItemService;

@Controller
public class PurchaseController {

	@Autowired
	private ItemService itemService;

	@RequestMapping(value = "/purchase")
	public String showBasketItems(Model model) {

		model.addAttribute("purchasedItems", itemService.findAllBuyableItems());
		itemService.resetBuyableItemBycount();
		return "purchase";
	}
}
