package com.alithya.shoppingcard.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.alithya.shoppingcard.entity.Item;
import com.alithya.shoppingcard.service.ItemService;

import jdk.net.SocketFlow.Status;

@RestController
@RequestMapping("/rest")
public class AdminShowAllItemsRestController {
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value = "/adminShowAllItems" , method = RequestMethod.GET)
	ResponseEntity<String> showItems(){
//		List<Item> items = new ArrayList<>();
//		items.addAll(itemService.findAll());


		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
