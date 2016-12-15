package com.alithya.shoppingcard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.alithya.shoppingcard.service.ItemService;

@Controller
public class UserShowAllItemsController {

	@Autowired
	private ItemService itemService;

	@RequestMapping(value = "/userShowAllItems", method = RequestMethod.POST)
	public String saveItem(HttpServletRequest request, Model model) {

		itemService.updateShoppingCard(request.getParameterValues("selectedItemIds"));
		model.addAttribute("allItems", itemService.findAll());

		return "userShowAllItems";

	}

	@RequestMapping("/userShowAllItems")
	public String showAllItemOnpage(Model model) {
		
		model.addAttribute("allItems", itemService.findAll());
		itemService.CreateBuyableItemList();
		return "userShowAllItems";
	}

}
