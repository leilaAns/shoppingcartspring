package com.alithya.shoppingcard.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan({"com.alithya.shoppingcard","com.alithya.shoppingcard.service","com.alithya.shoppingcard.controller","com.alithya.shoppingcard.repository","com.alithya.shoppingcard.resolvers","com.alithya.shoppingcard.persistence"})
@Import({UserSecurityConfig.class,PersistenceJPAConfig.class})
public class MyWebAppContextConfig extends WebMvcConfigurerAdapter  {
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	configurer.enable();
	}
	
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver(){
	InternalResourceViewResolver myResolver = new InternalResourceViewResolver();
	myResolver.setViewClass(JstlView.class);
	myResolver.setPrefix("/WEB-INF/views/");
	myResolver.setSuffix(".jsp");
	return myResolver;
	}
	
	
}
