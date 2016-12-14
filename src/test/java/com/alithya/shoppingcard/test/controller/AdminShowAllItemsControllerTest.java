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
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import com.alithya.shoppingcard.configuration.MyDispatcherServlet;
import com.alithya.shoppingcard.configuration.MyWebAppContextConfig;
import com.alithya.shoppingcard.controller.AdminShowAllItemsController;
import com.alithya.shoppingcard.entity.Item;
import com.alithya.shoppingcard.service.ItemService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MyDispatcherServlet.class, MyWebAppContextConfig.class })
@WebAppConfiguration
@ActiveProfiles("test")
public class AdminShowAllItemsControllerTest {

	@Mock
	private ItemService itmeService;

	@InjectMocks
	private AdminShowAllItemsController adminShowAllItemsController;

	private Model model = new ExtendedModelMap();

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testShowAllItem() {
		List<Item> items = new ArrayList<Item>();
		items.add(new Item(1, "name1", "type1", "des"));
		model.addAttribute("allItems", when(itmeService.findAll()).thenReturn((List) items));
		assertSame("retrun the correct page", "adminShowAllItems", adminShowAllItemsController.showAllItem(model));
		assertNotNull(model.asMap());

	}

}
