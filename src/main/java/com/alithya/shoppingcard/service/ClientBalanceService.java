package com.alithya.shoppingcard.service;

public interface ClientBalanceService {

	public double getClientBalance(int clientId);

	public int updateClietnBalance(int clientId, double account);

	public int rechargeClientBalance(int clientId, double account);
	
	
}
