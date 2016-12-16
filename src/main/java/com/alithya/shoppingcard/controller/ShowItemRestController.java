package com.alithya.shoppingcard.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alithya.shoppingcard.service.ItemService;

@RestController
@RequestMapping("/rest")
public class ShowItemRestController {
	@Autowired
	private ItemService itemService;
	
//	@RequestMapping(value = "/showItem/{itemId}", method = RequestMethod.GET)
//	ResponseEntity<Item> loadItem(@PathVariable itemId){
//		return new Response
//	}
	

}
