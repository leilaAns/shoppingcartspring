package com.alithya.shoppingcard.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import com.alithya.shoppingcard.service.BalanceConsumeService;

@Configuration
public class ConsumeWebServiceConfig{
	
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in pom.xml
		marshaller.setContextPath("localhost._8080.shoppingcartspring.soap.api.v1");
		return marshaller;
	}

	@Bean
	public BalanceConsumeService balanceClient(Jaxb2Marshaller marshaller) {
		BalanceConsumeService client = new BalanceConsumeService();
		client.setDefaultUri("http://localhost:8080/shoppingcartspring/ws/balance.wsdl");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}
