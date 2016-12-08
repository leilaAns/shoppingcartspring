package com.alithya.shoppingcard.test.controller;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
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
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.alithya.shoppingcard.configuration.MyDispatcherServlet;
import com.alithya.shoppingcard.configuration.MyWebAppContextConfig;
import com.alithya.shoppingcard.controller.SearchItemController;
import com.alithya.shoppingcard.entity.Item;
import com.alithya.shoppingcard.service.ItemService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MyDispatcherServlet.class, MyWebAppContextConfig.class })
@WebAppConfiguration
public class SearchItemControllerTest {

	@Mock
	private ItemService itmeService;

	@Autowired
	MockHttpSession session;

	@InjectMocks
	private SearchItemController searchItemController;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetItem() {

		List<Item> items = new ArrayList<Item>();
		items.add(new Item(1, "name1", "type1", "des"));
		session.setAttribute("itemResult", when(itmeService.findItemByKeySearch(anyString())).thenReturn((List) items));
		assertSame("redirect:/showSearchItemResultForUser", searchItemController.getItem("name1", session));
		assertNotNull("verifying session is not null", session.getAttribute("itemResult"));
	}

}
