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
import com.alithya.shoppingcard.service.ItemService;
import com.alithya.shoppingcard.statics.WebServiceStatics;


@Controller
public class PurchaseController {

	@Autowired
	private ItemService itemService;
	

	@RequestMapping(value = "/purchase")
	public String showBasketItems(Model model) {

		model.addAttribute("purchasedItems", itemService.findBuyableItemsInBasket());
		model.addAttribute("totalPrice", itemService.getTotalPrice());
		RestTemplate template = new RestTemplate();
	    ResponseEntity<Double> clientDoubleEntity = template.getForEntity(WebServiceStatics.GETBALANCE_URL_API,Double.class);
		 if(clientDoubleEntity.getStatusCodeValue() == 200)
			 model.addAttribute("balance", clientDoubleEntity.getBody().doubleValue());
		return "purchase";
	}
	 
	@RequestMapping(value = "/purchase" ,method = RequestMethod.POST)
	public String payOrRecharge(@RequestParam String action,Model model) {

		String destination = "redirect:/purchase";
		Map<String, String> map = new HashMap<String, String>();
		RestTemplate template = new RestTemplate();

		
		if (action.equals("pay")) {

			 ResponseEntity<Double> clientDoubleEntity = template.getForEntity(WebServiceStatics.GETBALANCE_URL_API,Double.class);
			 if(clientDoubleEntity.getStatusCodeValue() == 200){
					 double balance = clientDoubleEntity.getBody().doubleValue();
					 if(balance >= itemService.getTotalPrice()){
						
				        map.put("clientId", "1");
				        map.put("account", String.valueOf(balance - itemService.getTotalPrice()));
				        ResponseEntity<Void> clientEntity = template.getForEntity(WebServiceStatics.UPDATE_BALANCE_URL_API,Void.class ,map);
				        if(clientEntity.getStatusCodeValue() != 200){
				        	throw new RuntimeException("there is an exception in webService");
				        }
				        destination = "redirect:/finalPage";
					}
					
				} 
			 else
				 throw new RuntimeException("there is an exception in webService");
			 
		}
		else {
			
	        map.put("clientId", "1");
	        map.put("account", String.valueOf(100.0));
	        ResponseEntity<Void> clientEntity = template.getForEntity(WebServiceStatics.RECHARGE_BALANCE_URL_API,Void.class ,map);
	        if(clientEntity.getStatusCodeValue() != 200){
	        	throw new RuntimeException("there is an exception in webService");
	        }
		}
		return destination;
	}
	

}
