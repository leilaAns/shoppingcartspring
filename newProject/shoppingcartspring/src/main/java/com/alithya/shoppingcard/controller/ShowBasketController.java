package com.alithya.shoppingcard.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alithya.shoppingcard.entity.BuyableItem;
import com.alithya.shoppingcard.service.ItemService;

@Controller
public class ShowBasketController {

	@Autowired
	private ItemService itemService;

	@RequestMapping(value = "/showBasket")
	public String showBuyableItemsInBasket(HttpSession session, Model model) {
		model.addAttribute("allBuyableItemsInBasket", session.getAttribute("basketBuyableItem"));
		return "showBasket";
	}

	@RequestMapping(value = "/showBasket", method = RequestMethod.POST)
	public String showAndSaveBuyableItemsInBasket(HttpServletRequest request, Model model, HttpSession session,
			@RequestParam int count) {

		List<BuyableItem> buyableItemsInBasket = itemService.updateBuyableItemsInBasket(
				request.getParameterValues("markedAsDeletedFromBasket"),
				(List<BuyableItem>) session.getAttribute("basketBuyableItem"));

		model.addAttribute("allBuyableItemsInBasket", buyableItemsInBasket);
		session.setAttribute("SavedBuyableItemsInBasket", buyableItemsInBasket);
		return "showBasket";
	}
}
