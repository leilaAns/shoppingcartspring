package com.alithya.shoppingcard.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PurchaseController {

	@RequestMapping(value = "/purchase")
	public String showBasketItems(HttpSession session, Model model) {
		if (session.getAttribute("basketBuyableItem") != null) {
			model.addAttribute("purchasedItems", session.getAttribute("basketBuyableItem"));
			session.removeAttribute("basketBuyableItem");
		} else {
			model.addAttribute("purchasedItems", session.getAttribute("SavedBuyableItemsInBasket"));
			session.removeAttribute("SavedBuyableItemsInBasket");
		}

		return "purchase";
	}
}
