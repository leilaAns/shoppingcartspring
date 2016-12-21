package com.alithya.shoppingcard.repository;


import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.alithya.shoppingcard.exception.FinancialServiceException;


@Repository
public class ClientBalanceRepositoryImp implements ClientBalanceRepository {
	
	public static final String GET_BALANCE = "select available_balance from client_table where client_id = :clientId";
	public  static final String UPDATE_BALANCE = "update client_table set available_balance = :account where client_id = :clientId";
	public static final String RECHARGE_BALANCE = "update client_table set available_balance = available_balance + :account where client_id = :clientId";
	

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private SqlParameterSource namedParameters;
	private Map<String, Object> namedParametersMap;
	
	@Autowired
	public ClientBalanceRepositoryImp(DataSource dataSource) {

		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		namedParametersMap = new HashMap<>();

	}
	
	@Override
	public double getClientBalance(int clientId) throws FinancialServiceException{
		namedParameters = new MapSqlParameterSource("clientId", clientId);
		try{
			return namedParameterJdbcTemplate.queryForObject(GET_BALANCE, namedParameters,double.class);
		}catch (EmptyResultDataAccessException e) {
			throw new FinancialServiceException("transaction is not done");
		}catch (Exception e) {
			throw new FinancialServiceException("sql Exception");
		}
		
	}

	@Override
	public int updateClientBalance(int clientId,double account) throws FinancialServiceException {
		
		namedParametersMap.put("clientId",clientId);
		double balance =0;
		try{
			 balance = this.getClientBalance(clientId);
			 namedParametersMap.put("account", balance - account);
			 return  namedParameterJdbcTemplate.update(UPDATE_BALANCE, namedParametersMap);
		}catch (EmptyResultDataAccessException e) {
			throw new FinancialServiceException("transaction is not done");
		}catch (Exception e) {
			throw new FinancialServiceException("sql Exception");
		}
	   
	}

	@Override
	public int rechargeClientBalance(int clientId, double account) throws FinancialServiceException{
		namedParametersMap.put("account", account);
		namedParametersMap.put("clientId",clientId);
		try{
			
				return namedParameterJdbcTemplate.update(RECHARGE_BALANCE, namedParametersMap);
			
		}catch (EmptyResultDataAccessException  e) {
			throw new FinancialServiceException("transaction is not done");
		}catch (Exception e) {
			throw new FinancialServiceException("sql Exception");
		}
		
	}

	@Override
	public boolean isBalanceEnough(int clientId, double cost) throws FinancialServiceException{
	  double balance =0;
	  try{
		   balance = this.getClientBalance(clientId);
		  }catch (EmptyResultDataAccessException  e) {
			throw new FinancialServiceException("transaction is not done");
		}catch (Exception e) {
			throw new FinancialServiceException("sql Exception");
		}
	  if(balance >= cost)
		return true;
	  else
		  return false;
	}

}
