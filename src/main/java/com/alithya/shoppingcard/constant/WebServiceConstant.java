package com.alithya.shoppingcard.constant;

public class WebServiceConstant {
	
	public static final String CheckBALANCE_URL_API = "http://localhost:8080/shoppingcartspring/rest/api/v1//checkBalance/{clientId}/{cost}";
	public static final String UPDATE_BALANCE_URL_API = "http://localhost:8080/shoppingcartspring/rest/api/v1/updateBalance/{clientId}/{account}";
	public static final String RECHARGE_BALANCE_URL_API =  "http://localhost:8080/shoppingcartspring/rest/api/v1/rechargeBalance/{clientId}/{account}";

}
