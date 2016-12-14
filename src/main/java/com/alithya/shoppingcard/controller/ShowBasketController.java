package com.alithya.shoppingcard.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.alithya.shoppingcard.service.ItemService;

@Controller
public class ShowBasketController {

	@Autowired
	private ItemService itemService;

	@RequestMapping(value = "/showBasket")
	public String showBuyableItemsInBasket(Model model) {
		model.addAttribute("allBuyableItemsInBasket", itemService.findAllBuyableItems());
		return "showBasket";
	}

	@RequestMapping(value = "/showBasket", method = RequestMethod.POST)
	public String saveBuyableItemsInBasket(HttpServletRequest request, Model model) {

		for (String id : request.getParameterValues("markedAsDeletedFromBasket")) {

			itemService.updateBuyableItemBycount(Integer.parseInt(id), 0);
		}

		model.addAttribute("allBuyableItemsInBasket", itemService.findAllBuyableItems());
		return "showBasket";
	}
}
