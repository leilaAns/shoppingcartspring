package com.alithya.shoppingcard.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alithya.shoppingcard.entity.BuyableItem;
import com.alithya.shoppingcard.service.ItemService;

@Controller
public class UserShowAllItemsController {

	@Autowired
	private ItemService itemService;

	@RequestMapping(value = "/userShowAllItems", method = RequestMethod.POST)
	public String saveItem(HttpServletRequest request, HttpSession session, Model model) {

		List<BuyableItem> buyableList = new ArrayList<BuyableItem>();

		if (session.getAttribute("basketBuyableItem") != null) {

			buyableList = itemService.searchAndCountBuyableItemsInBasket(
					(List<BuyableItem>) session.getAttribute("basketBuyableItem"),
					request.getParameterValues("selectedItem"));

		} else
			for (String id : request.getParameterValues("selectedItem")) {

				BuyableItem buyableItem = itemService.CreateBuyableItem(Integer.parseInt(id), 1);
				buyableList.add(buyableItem);

			}

		session.setAttribute("basketBuyableItem", buyableList);
		model.addAttribute("allItems", this.itemService.findAll());

		return "userShowAllItems";

	}

	@RequestMapping("/userShowAllItems")
	public String showAllItemOnpage(Model model) {
		model.addAttribute("allItems", this.itemService.findAll());
		return "userShowAllItems";
	}

}
