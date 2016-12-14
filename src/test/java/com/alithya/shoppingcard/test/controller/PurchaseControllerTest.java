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
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import com.alithya.shoppingcard.entity.BuyableItem;
import com.alithya.shoppingcard.entity.Item;
import com.alithya.shoppingcard.service.ItemService;
import com.alithya.shoppingcard.configuration.MyDispatcherServlet;
import com.alithya.shoppingcard.configuration.MyWebAppContextConfig;
import com.alithya.shoppingcard.controller.PurchaseController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MyDispatcherServlet.class, MyWebAppContextConfig.class })
@WebAppConfiguration
public class PurchaseControllerTest {

	@Mock
	private ItemService itmeService;

	@InjectMocks
	private PurchaseController purchaseController;

	private Model model;
	private List<BuyableItem> buyableItemList;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		model = new ExtendedModelMap();
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
	public void testShowBasketItems() {

		model.addAttribute("purchasedItems",
				when(itmeService.findAllBuyableItems()).thenReturn((List<BuyableItem>) buyableItemList));
		assertTrue(model.containsAttribute("purchasedItems"));
		assertSame("return the correct page", "purchase", purchaseController.showBasketItems(model));

	}

}
