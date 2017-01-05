package com.alithya.shoppingcard.service;


import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import localhost._8080.shoppingcartspring.soap.api.v1.GetBalanceRequest;
import localhost._8080.shoppingcartspring.soap.api.v1.GetBalanceResponse;
import localhost._8080.shoppingcartspring.soap.api.v1.GetRechargeClientBalanceRequest;
import localhost._8080.shoppingcartspring.soap.api.v1.GetRechargeClientBalanceResponse;
import localhost._8080.shoppingcartspring.soap.api.v1.GetUpdateBalanceRequest;
import localhost._8080.shoppingcartspring.soap.api.v1.GetUpdateBalanceResponse;



public class BalanceConsumeService extends WebServiceGatewaySupport{
	
	
	public GetBalanceResponse getBalanceFromWebService(String clientId){
		
		GetBalanceRequest request = new GetBalanceRequest();
		request.setClientId(clientId);			
		GetBalanceResponse response = (GetBalanceResponse) getWebServiceTemplate()
				.marshalSendAndReceive(request ,new SoapActionCallback("http://localhost:8080/shoppingcartspring/ws/getBalanceRequest"));
		
		return response;
	
		
	}
	
	public GetRechargeClientBalanceResponse rechargeClientBalance(String clinetId,String amount){
	
		GetRechargeClientBalanceRequest request = new GetRechargeClientBalanceRequest();
		request.setClientId(clinetId);
		request.setAmount(amount);
		GetRechargeClientBalanceResponse response = (GetRechargeClientBalanceResponse) getWebServiceTemplate()
				.marshalSendAndReceive(request, new SoapActionCallback("http://localhost:8080/shoppingcartspring/ws/getRechargeClientBalanceRequest"));
		return response;
		
	}
	
	public GetUpdateBalanceResponse updateBalance(String clientId, String amount){
		GetUpdateBalanceRequest request = new GetUpdateBalanceRequest();
		request.setClientId(clientId);
		request.setAmount(amount);
		GetUpdateBalanceResponse response = (GetUpdateBalanceResponse)getWebServiceTemplate()
				.marshalSendAndReceive(request, new SoapActionCallback("http://localhost:8080/shoppingcartspring/ws/getUpdateBalanceRequest"));
		return response;
	}
	
}
