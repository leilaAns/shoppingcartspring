package com.alithya.shoppingcard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alithya.shoppingcard.repository.ClientBalanceRepository;
import com.alithya.shoppingcard.statics.WebServiceStatics;

@Service
public class ClientBalanceServiceImp implements ClientBalanceService {

	@Autowired
	ClientBalanceRepository clientBalanceRepository;

	private RestTemplate template = new RestTemplate();

	@Override
	public double getClientBalance(int clientId) {
		return clientBalanceRepository.getClientBalance(clientId);
	}

	@Override
	public int updateClietnBalance(int clientId, double account) {
		return clientBalanceRepository.updateClientBalance(clientId, account);
	}

	@Override
	public int rechargeClientBalance(int clientId, double account) {
		return clientBalanceRepository.rechargeClientBalance(clientId, account);
	}


}
