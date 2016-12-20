package com.alithya.shoppingcard.test.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import com.alithya.shoppingcard.configuration.MyDispatcherServlet;
import com.alithya.shoppingcard.configuration.MyWebAppContextConfig;
import com.alithya.shoppingcard.controller.UserShowAllItemsController;
import com.alithya.shoppingcard.entity.BuyableItem;
import com.alithya.shoppingcard.service.ItemService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyDispatcherServlet.class, MyWebAppContextConfig.class})
@WebAppConfiguration
public class UserShowAllItemsControllerTest {

	@Mock
	private ItemService itmeService ;
	
	@InjectMocks
	private UserShowAllItemsController userShowAllItemsController;
	
	private Model model = new ExtendedModelMap();
	
	private List<BuyableItem> buyableItemList;
	
	@Autowired
	MockHttpServletRequest request;
	
	
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);		
		buyableItemList = new ArrayList<>();
		BuyableItem buyableItem = new BuyableItem();
		buyableItem.setId(1);
		buyableItem.setName("name");
		buyableItem.setType("type");
		buyableItem.setDes("des");
		buyableItem.setCount(1);
		buyableItemList.add(buyableItem);
	}
	
	@Test
	public void testShowAllItemOnpage(){
		model.addAttribute("allItems", when(itmeService.findAll()).thenReturn((List)buyableItemList));
		assertNotNull(model.asMap());		
		assertTrue(model.containsAttribute("allItems"));
		assertSame("retrun the correct page", "userShowAllItems", userShowAllItemsController.showAllItemOnpage(model));
	}

	
	@Test
	public void testSaveItem(){
		model.addAttribute("allItems", when(itmeService.findAll()).thenReturn((List)buyableItemList));
		assertNotNull(model.asMap());		
		assertTrue(model.containsAttribute("allItems"));
		assertSame("retrun the correct page", "userShowAllItems", userShowAllItemsController.saveItem(request, model));
		
		
	}
}
