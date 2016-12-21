package com.alithya.shoppingcard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alithya.shoppingcard.repository.ClientBalanceRepository;


@Service
public class ClientBalanceServiceImp implements ClientBalanceService {

	@Autowired
	ClientBalanceRepository clientBalanceRepository;


	@Override
	public double getClientBalance(int clientId) {
		return clientBalanceRepository.getClientBalance(clientId);
	}

	@Override
	public int updateClietnBalance(int clientId, double account){
		 return clientBalanceRepository.updateClientBalance(clientId, account);
	}

	@Override
	public int rechargeClientBalance(int clientId, double account) {
		return clientBalanceRepository.rechargeClientBalance(clientId, account);
	}


}
