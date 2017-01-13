package com.alithya.shoppingcard.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.alithya.shoppingcard.service.BalanceConsumeService;
import com.alithya.shoppingcard.service.ItemServiceBasketMethods;



@Controller
public class PurchaseController {

	@Autowired
	private ItemServiceBasketMethods itemService;
	
	@Autowired
	private BalanceConsumeService balanceConsumeService;
	

	@RequestMapping(value = "/purchase")
	public String showBasketItems(Model model) {

		model.addAttribute("purchasedItems", itemService.findBuyableItemsInBasket());
		model.addAttribute("totalPrice", itemService.getTotalPrice());
		return "purchase";
	}
	 
	@RequestMapping(value = "/purchase" ,method = RequestMethod.POST)
	public String payOrRecharge(@RequestParam String action,Model model) {

		String destination = "redirect:/purchase";
        double amount = itemService.getTotalPrice();

		if (action.equals("pay")) {
			
			double balance = Double.valueOf(balanceConsumeService.getBalanceFromWebService("1").getBalance());
			if(balance >= amount){
				balanceConsumeService.updateBalance("1", String.valueOf(amount));
				destination = "redirect:/receipt";
			}
			 
		}
		else if(action.equals("recharge")) {
			
			
			balanceConsumeService.rechargeClientBalance("1", String.valueOf(100.0));

		}
		return destination;
	}
	

}
