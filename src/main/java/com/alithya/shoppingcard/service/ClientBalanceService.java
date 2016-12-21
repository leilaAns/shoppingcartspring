package com.alithya.shoppingcard.service;

import java.sql.SQLException;

import com.alithya.shoppingcard.exception.FinancialServiceException;

public interface ClientBalanceService {

	public double getClientBalance(int clientId) throws FinancialServiceException;

	public int updateClietnBalance(int clientId, double account) throws FinancialServiceException;

	public int rechargeClientBalance(int clientId, double account)throws FinancialServiceException;
	
	public boolean isBalanceEnough(int clientId, double cost) throws FinancialServiceException;

}
