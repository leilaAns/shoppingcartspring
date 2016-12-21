package com.alithya.shoppingcard.repository;

import java.sql.SQLException;

import com.alithya.shoppingcard.exception.FinancialServiceException;

public interface ClientBalanceRepository {

	public double getClientBalance(int clientId) throws SQLException,FinancialServiceException;

	public int updateClientBalance(int clientId, double account) throws SQLException, FinancialServiceException ;
	
	public int rechargeClientBalance(int clientId,double account) throws SQLException, FinancialServiceException;
	
	public boolean isBalanceEnough(int clientId, double cost) throws SQLException, FinancialServiceException;

}
