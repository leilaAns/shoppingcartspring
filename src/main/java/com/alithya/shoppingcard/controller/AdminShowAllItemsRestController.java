package com.alithya.shoppingcard.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.alithya.shoppingcard.entity.Item;
import com.alithya.shoppingcard.service.ItemService;

@RestController
@RequestMapping("/rest")
public class AdminShowAllItemsRestController {
	@Autowired
	private ItemService itemService;

	@RequestMapping(value = "/adminShowAllItems", method = RequestMethod.GET)
	List<Item> showItems() {
		List<Item> items = new ArrayList<>();
		items.addAll(itemService.findAll());
		return items;

	}

}
