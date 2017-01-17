package com.alithya.shoppingcard.test.repository;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.alithya.shoppingcard.configuration.MyDataSourceConfig;
import com.alithya.shoppingcard.repository.ClientBalanceRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MyDataSourceConfig.class)
@Transactional
@ActiveProfiles("test")
public class ClientBalanceRepositoryImpTest {

	@Autowired
	ClientBalanceRepository clientBalanceRepository;
	
	@Test
	public void testGetClientBalance() {
		//double balance = clientBalanceRepository.getClientBalance(1);
		//assertNotNull(balance);
	}
	
	@Test
	public void testUpdateClientBalance(){
		//int result = clientBalanceRepository.updateClientBalance(1,20.0);
		//assertEquals(1,result);
	}

	@Test
	public void testRechargeClientBalance(){
		//int result = clientBalanceRepository.rechargeClientBalance(1,20.0);
		//assertEquals(1,result);
	}
}
