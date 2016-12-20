package com.alithya.shoppingcard.repository;


import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;


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
	public double getClientBalance(int clientId) {
		namedParameters = new MapSqlParameterSource("clientId", clientId);
		return namedParameterJdbcTemplate.queryForObject(GET_BALANCE, namedParameters,double.class);
	}

	@Override
	public int updateClientBalance(int clientId,double account) {
		namedParametersMap.put("account", account);
		namedParametersMap.put("clientId",clientId);
		return namedParameterJdbcTemplate.update(UPDATE_BALANCE, namedParametersMap);
	}

	@Override
	public int rechargeClientBalance(int clientId, double account) {
		namedParametersMap.put("account", account);
		namedParametersMap.put("clientId",clientId);
		return namedParameterJdbcTemplate.update(RECHARGE_BALANCE, namedParametersMap);
	}

}
