package com.alithya.shoppingcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.alithya.shoppingcard.service.ClientBalanceService;

@RestController
@RequestMapping("/rest/api/v1")
public class FinancialRestController {

	@Autowired
	private ClientBalanceService clientBalanceService;

	@RequestMapping(value = "/checkBalance/{clientId}/{cost}", method = RequestMethod.GET)
	public ResponseEntity<String> checkBalance(@PathVariable int clientId, @PathVariable double cost) throws Exception {
		String message = "";
		try {
			clientBalanceService.isBalanceEnough(clientId, cost);
			message = "isdone";

		} catch (Exception e) {
			message = e.getMessage();
		}
		return new ResponseEntity<String>(message, HttpStatus.OK);

	}

	@RequestMapping(value = "/updateBalance/{clientId}/{account}", method = RequestMethod.GET)
	public ResponseEntity<String> updateBalance(@PathVariable int clientId, @PathVariable double account)
			throws Exception {

		String message = "";

		try {
			clientBalanceService.updateClietnBalance(clientId, account);
			message = "isdone";

		} catch (Exception e) {
			message = e.getMessage();
		}
		return new ResponseEntity<String>(message, HttpStatus.OK);

	}

	@RequestMapping(value = "/rechargeBalance/{clientId}/{account}", method = RequestMethod.GET)
	public ResponseEntity<String> rechargeBalance(@PathVariable int clientId, @PathVariable double account)throws Exception {

		String message = "";
		try {
			clientBalanceService.rechargeClientBalance(clientId, account);
			message = "isdone";

		} catch (Exception e) {
			message = e.getMessage();

		}
		return new ResponseEntity<String>(message, HttpStatus.OK);

	}

}
