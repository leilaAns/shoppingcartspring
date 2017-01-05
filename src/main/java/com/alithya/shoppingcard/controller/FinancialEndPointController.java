package com.alithya.shoppingcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.alithya.shoppingcard.constant.WebServiceConstant;
import com.alithya.shoppingcard.exception.FinancialServiceException;
import com.alithya.shoppingcard.service.ClientBalanceService;
import localhost._8080.shoppingcartspring.soap.api.v1.GetBalanceRequest;
import localhost._8080.shoppingcartspring.soap.api.v1.GetBalanceResponse;
import localhost._8080.shoppingcartspring.soap.api.v1.GetRechargeClientBalanceRequest;
import localhost._8080.shoppingcartspring.soap.api.v1.GetRechargeClientBalanceResponse;
import localhost._8080.shoppingcartspring.soap.api.v1.GetUpdateBalanceRequest;
import localhost._8080.shoppingcartspring.soap.api.v1.GetUpdateBalanceResponse;



@Endpoint
public class FinancialEndPointController {

	

	@Autowired
	private ClientBalanceService clientBalanceService;
	
	@PayloadRoot(namespace = WebServiceConstant.SOAP_NAMESPACE_URI, localPart = "getBalanceRequest")
	@ResponsePayload
	public GetBalanceResponse getbalance(@RequestPayload GetBalanceRequest request) throws FinancialServiceException{
		GetBalanceResponse response = new GetBalanceResponse();
		response.setBalance(String.valueOf(clientBalanceService.getClientBalance(Integer.parseInt(request.getClientId()))));
		return response;
		
	}
	
	@PayloadRoot(namespace = WebServiceConstant.SOAP_NAMESPACE_URI, localPart = "getUpdateBalanceRequest")
	@ResponsePayload
	public GetUpdateBalanceResponse getUpdateBalance(@RequestPayload GetUpdateBalanceRequest request) throws FinancialServiceException{
		GetUpdateBalanceResponse response = new GetUpdateBalanceResponse();
		response.setResponse(String.valueOf(clientBalanceService.updateClietnBalance(Integer.parseInt(request.getClientId()), Double.parseDouble(request.getAmount()))));
		return response;		
	}
	
	
	@PayloadRoot(namespace = WebServiceConstant.SOAP_NAMESPACE_URI, localPart = "getRechargeClientBalanceRequest")
	@ResponsePayload
	public GetRechargeClientBalanceResponse getUpdateBalance(@RequestPayload GetRechargeClientBalanceRequest request) throws FinancialServiceException{
		GetRechargeClientBalanceResponse response = new GetRechargeClientBalanceResponse();
		response.setResponse(String.valueOf(clientBalanceService.rechargeClientBalance(Integer.parseInt(request.getClientId()), Double.parseDouble(request.getAmount()))));
		return response;		
	}
	
}
