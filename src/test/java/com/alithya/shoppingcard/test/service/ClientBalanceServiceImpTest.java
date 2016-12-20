package com.alithya.shoppingcard.test.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;
import com.alithya.shoppingcard.repository.ClientBalanceRepository;
import com.alithya.shoppingcard.service.ClientBalanceService;
import com.alithya.shoppingcard.service.ClientBalanceServiceImp;


@ActiveProfiles("test")
public class ClientBalanceServiceImpTest {

	@Mock
	private ClientBalanceRepository clientBalanceRepository;
	
	@InjectMocks
	private ClientBalanceService clientBalanceService = new ClientBalanceServiceImp();
	
	@Before
	public void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
		
	}
	
	@Test
	public void testGetClientBalance() {
		double balance = 1000.0;
		when(clientBalanceRepository.getClientBalance(1)).thenReturn(balance);
		assertNotNull(clientBalanceRepository.getClientBalance(1));
	}
	
	@Test
	public void testUpdateClietnBalance(){
		int result = 1;
		when(clientBalanceRepository.updateClientBalance(1, 20.0)).thenReturn(result);
		assertEquals(1,result);
	}
	
	@Test
	public void testRechargeClientBalance(){
		int result = 1;
		when(clientBalanceRepository.rechargeClientBalance(1, 20.0)).thenReturn(result);
		assertEquals(1,result);
	}

}
