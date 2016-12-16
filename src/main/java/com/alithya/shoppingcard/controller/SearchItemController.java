package com.alithya.shoppingcard.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alithya.shoppingcard.service.ItemService;

@Controller
public class SearchItemController {

	@Autowired
	ItemService itemService;

	@RequestMapping("searchItem")
	public String getPage() {
		return "searchItem";

	}

	@RequestMapping(value = "searchItem", method = RequestMethod.POST)
	public String getItem(@RequestParam String name, HttpSession session) {
		session.setAttribute("itemsResult", this.itemService.findItemByKeySearch(name));
		return "redirect:/showSearchItemResultForUser";
	}
}
