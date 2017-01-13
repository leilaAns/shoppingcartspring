package com.alithya.shoppingcard.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.alithya.shoppingcard.entity.Item;
import com.alithya.shoppingcard.persistence.ItemEntity;
import com.alithya.shoppingcard.service.ItemService;

@Controller
@SessionAttributes("Item")
public class CreateNewItemController {

	@Autowired
	private ItemService<?> itemService;

	@RequestMapping(value = "/createNewItem")
	public String saveItem(@ModelAttribute Item item) {
		return "createNewItem";
	}

	@RequestMapping(value = "/createNewItem", method = RequestMethod.POST)
	public String showAllItems(@ModelAttribute Item item) {
		ItemEntity itemEntity = new ItemEntity();
		BeanUtils.copyProperties(item, itemEntity);
	//	itemService.addNewItem(itemEntity);
		return "redirect:/adminShowAllItems";
	}

}
