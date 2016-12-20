package com.alithya.shoppingcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.alithya.shoppingcard.service.ClientBalanceService;

@RestController
@RequestMapping("/rest/api/v1")
public class GetBalanceRestController {

	@Autowired
	private ClientBalanceService clientBalanceService;

	@RequestMapping(value = "/getBalance", method = RequestMethod.GET)
	public ResponseEntity<Double> getBalance() {

		try {

			return new ResponseEntity<Double>(clientBalanceService.getClientBalance(1), HttpStatus.OK);

		} catch (Exception ex) {

			return new ResponseEntity<Double>(0.0, HttpStatus.NOT_FOUND);
		}
	
	}

	@RequestMapping(value = "/updateBalance/{clientId}/{account}", method = RequestMethod.GET)
	public ResponseEntity<Void> updateBalance(@PathVariable int clientId, @PathVariable double account) {
		int result = clientBalanceService.updateClietnBalance(clientId, account);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		if (result == 1) {
			
			return new ResponseEntity<Void>(headers, HttpStatus.OK);
			
		} else {
			
			return new ResponseEntity<Void>(headers, HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "/rechargeBalance/{clientId}/{account}", method = RequestMethod.GET)
	public ResponseEntity<Void> rechargeBalance(@PathVariable int clientId, @PathVariable double account) {
		int result = clientBalanceService.rechargeClientBalance(clientId, account);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		if (result == 1) {

			return new ResponseEntity<Void>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(headers, HttpStatus.NOT_FOUND);
		}

	}

}
