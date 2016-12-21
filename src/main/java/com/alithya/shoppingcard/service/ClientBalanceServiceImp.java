package com.alithya.shoppingcard.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alithya.shoppingcard.exception.FinancialServiceException;
import com.alithya.shoppingcard.repository.ClientBalanceRepository;


@Service
public class ClientBalanceServiceImp implements ClientBalanceService {

	@Autowired
	ClientBalanceRepository clientBalanceRepository;


	@Override
	public double getClientBalance(int clientId)throws SQLException, FinancialServiceException {
		return clientBalanceRepository.getClientBalance(clientId);
	}

	@Override
	public int updateClietnBalance(int clientId, double account) throws SQLException, FinancialServiceException{
		 return clientBalanceRepository.updateClientBalance(clientId, account);
	}

	@Override
	public int rechargeClientBalance(int clientId, double account) throws SQLException, FinancialServiceException{
		return clientBalanceRepository.rechargeClientBalance(clientId, account);
	}

	@Override
	public boolean isBalanceEnough(int clientId, double cost) throws SQLException, FinancialServiceException {
		return clientBalanceRepository.isBalanceEnough(clientId, cost);
	}


}
