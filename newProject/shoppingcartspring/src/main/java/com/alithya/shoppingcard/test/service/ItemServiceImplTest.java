package com.alithya.shoppingcard.test.service;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import com.alithya.shoppingcard.entity.BuyableItem;
import com.alithya.shoppingcard.entity.Item;
import com.alithya.shoppingcard.service.ItemService;
import com.alithya.shoppingcard.service.ItemServiceImpl;


public class ItemServiceImplTest {


	private  static ItemService itemService;
	private  static List<Item> itemList;
	private static BuyableItem buyableItme;
	private  static List<BuyableItem> buyableItemList;
	
	
	@BeforeClass
	public static void setUp() throws Exception {
	
		itemService = new ItemServiceImpl();
	    itemList = new ArrayList<Item>();
		itemList.add(new Item(1, "name1", "type1", "des"));
		itemList.add(new Item(2, "name2", "type2", "des"));
		itemList.add(new Item(3, "name3", "type3", "des"));
		itemList.add(new Item(4, "name4", "type4", "des"));
		itemList.add(new Item(5, "name5", "type5", "des"));
		itemList.add(new Item(6, "name6", "type6", "des"));
		itemList.add(new Item(7, "name7", "type7", "des"));
		itemList.add(new Item(8, "name8", "type8", "des"));
		itemList.add(new Item(9, "name9", "type9", "des9"));
	    buyableItme = new BuyableItem();
		buyableItme.setId(2);
		buyableItme.setName("name");
		buyableItme.setType("type");
		buyableItme.setDes("des");
		buyableItme.setCount(5);	
		
	    BuyableItem buyableItme2 = new BuyableItem();
		buyableItme2.setId(1);
		buyableItme2.setName("name");
		buyableItme2.setType("type");
		buyableItme2.setDes("des");
		buyableItme2.setCount(2);
		
	    BuyableItem buyableItme3 = new BuyableItem();
		buyableItme3.setId(3);
		buyableItme3.setName("name");
		buyableItme3.setType("type");
		buyableItme3.setDes("des");
		buyableItme3.setCount(1);
		
		buyableItemList = new ArrayList<>();
		buyableItemList.add(buyableItme);
		buyableItemList.add(buyableItme2);
		buyableItemList.add(buyableItme3);
	}
	

	
	@Test
	public void testFinAllIsNotNull(){
	  assertNotNull(itemService.findAll());
	  assertTrue(itemService.findAll().size() == 9);
	}
	
	@Test
	public void testFindExistingElement(){
		assertNotNull(itemService.find(2));
		assertEquals(itemList.get(1).getName(), itemService.find(2).getName());
	}
	@Test
	public void testFindIsNonExistingElement(){
		assertNull(itemService.find(9999).getName());
	}	
	@Test
	public void testFindByNameIsNotNull_hasExpectedValue(){
		assertNotNull(itemService.findByName("name1"));
		assertEquals(itemList.get(3).getName(), itemService.findByName("name4").get(0).getName());
		
	}
	
	@Test
	public void testFindByNameIsNotExist(){
		assertTrue(itemService.findByName("name1000").size() == 0);
		
	}
	
	@Test
	public void testFindByTypeIsNotNull_hasExpectedValue(){
		assertNotNull(itemService.findByType("type1"));
		assertEquals(itemList.get(3).getType(), itemService.findByType("type4").get(0).getType());
	}
	
	@Test
	public void testFindByTypeIsNotExist(){
		assertTrue(itemService.findByType("type1000").size() == 0);
		
	}
	
	@Test
	public void testFindByDescriptinIsNotNull_hasExpectedValue(){
		assertNotNull(itemService.findByDescription("des9").get(0).getDes());
		assertEquals(itemList.get(3).getDes(), itemService.findByDescription("des").get(0).getDes());		
	}
	
	@Test
	public void testFindByDescriptionIsNotExist(){
		assertTrue(itemService.findByDescription("des1000").size() == 0);
		
	}
	
	@Test
	public void testDeletItem(){
		itemService.deleteItem(1);
		assertEquals(itemService.find(1).getId(), 0);
	}
	
	@Test
	public void testEditItem(){
		Item item = new Item(1, "newName", "newtype", "newDes");
		itemService.editItem(1, item);
		assertEquals(itemService.find(1).getName(), "newName");
		assertEquals(itemService.find(1).getType(), "newtype");
		assertEquals(itemService.find(1).getDes(), "newDes");
		assertNotEquals(itemService.find(1).getDes(), "des");
	}
	
	@Test
	public void testAddNewItem(){
		Item item = new Item(10, "name10","type10", "des10");
		itemService.addNewItem(item);
		 assertTrue(itemService.findAll().size() == 10);		
	}
	
	@Test
	public void testCreateBuyableItem(){
		BuyableItem buyableItemCreatedByService = itemService.CreateBuyableItem(2, 5);
		assertEquals(buyableItme.getCount(),buyableItemCreatedByService.getCount());
		assertEquals(buyableItme.getId(), buyableItemCreatedByService.getId());
	}
	
	@Test
	public void testFindItemByKeySearch_description(){
		List<Item> findedItems = itemService.findItemByKeySearch("des9");
		assertEquals(findedItems.size(), 1);
		List<Item> findedItems2 = itemService.findItemByKeySearch("des");
		assertEquals(findedItems2.size(), 9);
	}
	
	@Test
	public void testFindItemByKeySearch_name(){
		List<Item> findedItems = itemService.findItemByKeySearch("name1");
		assertEquals(findedItems.size(), 1);
		List<Item> findedItems2 = itemService.findItemByKeySearch("name");
		assertEquals(findedItems2.size(), 9);
	}
	
	@Test
	public void testFindItemByKeySearch_type(){
		List<Item> findedItems = itemService.findItemByKeySearch("type1");
		assertEquals(findedItems.size(), 1);
		List<Item> findedItems2 = itemService.findItemByKeySearch("type");
		assertEquals(findedItems2.size(), 9);
	}
	
	@Test
	public void testSearchAndCountBuyableItemsInBasket(){
		
		String[] id = {"2"};
		List<BuyableItem> buyableItemInBasket = itemService.searchAndCountBuyableItemsInBasket(buyableItemList,id);
		assertEquals(buyableItemInBasket.get(0).getCount(), 6);
		
	}
	
	@Test
	public void testUpdateBuyableItemsInBasket(){	
		String[] ids = {"1","3"};
		List<BuyableItem> buyableItemInBasket = itemService.updateBuyableItemsInBasket(ids, buyableItemList);
		assertEquals(buyableItemInBasket.get(0).getId(), 2);		
	}
	
}


