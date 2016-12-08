package com.alithya.shoppingcard.test.controller;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.support.SimpleSessionStatus;
import com.alithya.shoppingcard.configuration.MyDispatcherServlet;
import com.alithya.shoppingcard.configuration.MyWebAppContextConfig;
import com.alithya.shoppingcard.controller.SearchItemResultForUserController;
import com.alithya.shoppingcard.entity.Item;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyDispatcherServlet.class, MyWebAppContextConfig.class})
@WebAppConfiguration
public class SearchItemResultForUserControllerTest {


	@Autowired
	MockHttpSession session;
	

	@InjectMocks
	private SearchItemResultForUserController searchItemResultForUserController;
	
	private Model model = new ExtendedModelMap();
	private SessionStatus sessionStatus = new SimpleSessionStatus();
	private List<Item> itmeList = new ArrayList<Item>();
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);		
	}
	

	
	@Test 
	public void testShowResult(){

		String results = searchItemResultForUserController.showResult(session,  model, sessionStatus);
		assertTrue("return the correct page", "showSearchItemResultForUser".equals(results));
		assertTrue(model.containsAttribute("result"));
		itmeList.add(new Item(1,"name","type","des"));
		session.setAttribute("itemsResult", itmeList);
		assertNotNull(session.getAttribute("itemsResult"));
		model.addAttribute(session.getAttribute("itemsResult"));
		assertNotNull(model.asMap());
		
	}
	

}
