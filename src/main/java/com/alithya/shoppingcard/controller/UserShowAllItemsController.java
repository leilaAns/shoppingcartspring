package com.alithya.shoppingcard.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.alithya.shoppingcard.service.ItemService;
import com.alithya.shoppingcard.service.BasketServiceByHibernate;
import com.alithya.shoppingcard.service.ItemServiceImpl;

@Controller
public class UserShowAllItemsController {

	@Autowired
	private ItemService<?> itemService;
	
	@Autowired
    private BasketServiceByHibernate itemService2;

	@RequestMapping(value = "/userShowAllItems", method = RequestMethod.POST)
	public String saveItem(HttpServletRequest request, Model model) {

		itemService2.updateShoppingCard(request.getParameterValues("selectedItemIds"));
		model.addAttribute("allItems", itemService.findAll());
		return "userShowAllItems";

	}

	@RequestMapping("/userShowAllItems")
	public String showAllItemOnpage(Model model) {

		model.addAttribute("allItems", itemService.findAll());
		itemService2.CreateBuyableItemList();
		return "userShowAllItems";
	}

}
