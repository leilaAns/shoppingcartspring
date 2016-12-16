package com.alithya.shoppingcard.test.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.alithya.shoppingcard.configuration.MyDispatcherServlet;
import com.alithya.shoppingcard.configuration.MyWebAppContextConfig;
import com.alithya.shoppingcard.controller.CreateNewItemController;
import com.alithya.shoppingcard.entity.Item;
import com.alithya.shoppingcard.service.ItemService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MyDispatcherServlet.class, MyWebAppContextConfig.class })
@WebAppConfiguration
public class CreateNewItemControllerTest {

	@Mock
	private ItemService itmeService;

	@InjectMocks
	private CreateNewItemController createNewItemController;

	private Item item = new Item(1, "name", "type", "des");

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testSaveItem() {
		doNothing().when(itmeService).addNewItem(item);
		assertSame("retrun the correct page", "createNewItem", createNewItemController.saveItem(item));
	}

	@Test
	public void testShowAllItems() {
		doNothing().when(itmeService).addNewItem(item);
		assertSame("retrun the correct page", "redirect:/adminShowAllItems",
				createNewItemController.showAllItems(item));
	}

}
