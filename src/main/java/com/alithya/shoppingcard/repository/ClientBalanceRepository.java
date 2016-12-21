package com.alithya.shoppingcard.repository;

public interface ClientBalanceRepository {

	public double getClientBalance(int clientId);

	public int updateClientBalance(int clientId, double account) ;
	
	public int rechargeClientBalance(int clientId,double account);

}
