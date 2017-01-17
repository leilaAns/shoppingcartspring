package com.alithya.shoppingcard.configuration;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
@ComponentScan({"io.spring.guides.gs_producing_web_service","com.alithya.shoppingcard","com.alithya.shoppingcard.service","com.alithya.shoppingcard.controller","com.alithya.shoppingcard.repository","com.alithya.shoppingcard.resolvers"})
public class WebServiceConfig  extends WsConfigurerAdapter{
	
	@Bean(name = "balance")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema balanceSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("balancePort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://localhost:8080/shoppingcartspring/soap/api/v1");
		wsdl11Definition.setSchema(balanceSchema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema balanceSchema() {
		return new SimpleXsdSchema(new ClassPathResource("balance.xsd"));
	}

}
