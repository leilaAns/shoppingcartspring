package com.alithya.shoppingcard.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alithya.shoppingcard.service.ItemServiceBasketMethods;
import com.alithya.shoppingcard.service.ItemServiceImpl;

@Controller
public class ShowBasketController {

	@Autowired
    private ItemServiceBasketMethods itemService;

	@RequestMapping(value = "/showBasket")
	public ModelAndView showBuyableItemsInBasket(Model model) {

		model.addAttribute("allBuyableItemsInBasket", itemService.findBuyableItemsInBasket());
		return new ModelAndView("showBasket");
	}

	@RequestMapping(value = "/showBasket", method = RequestMethod.POST)
	public String saveBuyableItemsInBasket(HttpServletRequest request, Model model) {

		itemService.resetBuyableItemCount(request.getParameterValues("markedAsDeletedFromBasket"));
		model.addAttribute("allBuyableItemsInBasket", itemService.findBuyableItemsInBasket());
		return "showBasket";
	}
}
