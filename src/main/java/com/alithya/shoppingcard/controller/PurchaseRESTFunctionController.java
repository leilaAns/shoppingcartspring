package com.alithya.shoppingcard.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.alithya.shoppingcard.constant.WebServiceConstant;
import com.alithya.shoppingcard.service.ItemService;

@Controller
public class PurchaseRESTFunctionController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value = "/purchaseRest")
	public String showBasketItems(Model model) {

		model.addAttribute("purchasedItems", itemService.findBuyableItemsInBasket());
		model.addAttribute("totalPrice", itemService.getTotalPrice());
		return "purchase";
	}
	
	@RequestMapping(value = "/purchaseRest" ,method = RequestMethod.POST)
	public String payOrRecharge(@RequestParam String action,Model model) {
		String destination = "redirect:/purchase";
		Map<String, String> map = new HashMap<String, String>();
		RestTemplate template = new RestTemplate(); 
		if (action.equals("pay")) {
 
	        map.put("clientId", "1");
	        map.put("cost", String.valueOf(itemService.getTotalPrice()));
			 ResponseEntity<String> clientCheckBalance = template.getForEntity(WebServiceConstant.CHECKBALANCE_URL_API,String.class,map);
			 System.out.println(clientCheckBalance.getBody());
			 if(clientCheckBalance.getBody().equals("isdone")){
				
				        map.put("clientId", "1");
				        map.put("account", String.valueOf(itemService.getTotalPrice()));
				        ResponseEntity<String> clientEntity = template.getForEntity(WebServiceConstant.UPDATE_BALANCE_URL_API,String.class ,map);
				        System.out.println(clientEntity.getBody());
				        if(clientEntity.getBody().equals("isdone")){
				        	destination = "redirect:/receipt";
				        }
				        else{
				        	throw new RuntimeException("there is an exception in webService");
				        }
				
				} 
			 else
				 throw new RuntimeException("there is an exception in webService");
		}
		else if(action.equals("recharge")) {
	        map.put("clientId", "1");
	        map.put("account", String.valueOf(100.0));
	        ResponseEntity<String> clientEntity = template.getForEntity(WebServiceConstant.RECHARGE_BALANCE_URL_API,String.class ,map);
	        if(!clientEntity.getBody().equals("isdone")){
	        	throw new RuntimeException("there is an exception in webService");
	        }
		}
		return destination;
	}
}
