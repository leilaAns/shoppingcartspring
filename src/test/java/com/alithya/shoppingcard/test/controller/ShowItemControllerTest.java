package com.alithya.shoppingcard.test.controller;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import com.alithya.shoppingcard.configuration.MyDispatcherServlet;
import com.alithya.shoppingcard.configuration.MyWebAppContextConfig;
import com.alithya.shoppingcard.controller.ShowItemController;
import com.alithya.shoppingcard.entity.Item;
import com.alithya.shoppingcard.service.ItemService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyDispatcherServlet.class, MyWebAppContextConfig.class})
@WebAppConfiguration
public class ShowItemControllerTest {

	@Mock
	private ItemService itmeService ;
	
	@InjectMocks
	private ShowItemController showOneItemController;
	
	private Model model;
	private Item item;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);		
		model = new ExtendedModelMap();
		item = new Item(1, "name", "type","des");
	}
	
	@Test
	public void testShowItem(){
		model.addAttribute("item", when(itmeService.find(anyInt())).thenReturn(item));
		assertTrue("verifying model has added attribute", model.containsAttribute("item"));
		assertSame("return the correct page", "showOneItem", showOneItemController.showItem(model, item.getId()));
		
	}
	
	@Test
	public void testEditItem(){

	    doNothing().when(itmeService).editItem(item);
	    assertSame("return the correct page", "redirect:/adminShowAllItems", showOneItemController.editOrDeleteItem("edit",item));
	
	}
	
	@Test
	public void testDelelteItem(){
	
	    doNothing().when(itmeService).deleteItem(anyInt());
	    assertSame("return the correct page", "redirect:/adminShowAllItems", showOneItemController.editOrDeleteItem("delete",item));
	
	}

}
