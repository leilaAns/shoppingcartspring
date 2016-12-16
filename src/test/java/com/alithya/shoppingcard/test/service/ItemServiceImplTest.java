package com.alithya.shoppingcard.test.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;
import com.alithya.shoppingcard.entity.BuyableItem;
import com.alithya.shoppingcard.entity.Item;
import com.alithya.shoppingcard.repository.ItemRepository;
import com.alithya.shoppingcard.service.ItemService;
import com.alithya.shoppingcard.service.ItemServiceImpl;

@ActiveProfiles("test")
public class ItemServiceImplTest {

	@Mock
	private ItemRepository itemRepository;

	@InjectMocks
	private ItemService itemService = new ItemServiceImpl();

	private List<Item> itemList;
	private BuyableItem buyableItme;
	private List<BuyableItem> buyableItemList;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
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
	public void testFinAllIsNotNull() {
		when(itemRepository.findAll()).thenReturn((List<Item>) itemList);
		assertNotNull(itemService.findAll());
		assertTrue(itemService.findAll().size() == 9);
	}

	@Test
	public void testFindItemById() {
		when(itemRepository.findById(111)).thenReturn((new Item(111, "name", "type", "des")));
		assertNotNull(itemService.find(111));
		assertEquals("name", itemService.find(111).getName());
	}

	@Test
	public void testFindByNameIsNotNull() {
		when(itemRepository.findByName("name1")).thenReturn((itemList));
		assertNotNull(itemService.findByName("name1"));
		assertEquals(itemService.findByName("name1").get(0), itemList.get(0));

	}

	@Test
	public void testFindByNameHasExpectedValue() {
		when(itemRepository.findByName("name1")).thenReturn((itemList));
		assertEquals(itemService.findByName("name1").get(0), itemList.get(0));

	}

	@Test
	public void testFindByTypeIsNotNull() {
		when(itemRepository.findByType("type1")).thenReturn((itemList));
		assertNotNull(itemService.findByType("type1"));

	}

	@Test
	public void testFindByTypeHasExpectedValue() {
		when(itemRepository.findByType("type1")).thenReturn((itemList));
		assertEquals(itemList.get(0).getType(), itemService.findByType("type1").get(0).getType());

	}

	@Test
	public void testFindByDescriptinIsNotNull() {
		when(itemRepository.findByDescription("des1")).thenReturn((itemList));
		assertNotNull(itemService.findByDescription("des1").get(0).getDes());

	}

	@Test
	public void testDeletItem() {
		doNothing().when(itemRepository).deleteItem(1);
		itemService.deleteItem(1);
		assertNull(itemService.find(1));
	}

	@Test
	public void testFindItemByKeySearch_description() {
		when(itemRepository.findByDescription("des9")).thenReturn((itemList));
		List<Item> findedItems = itemService.findItemByKeySearch("des9");
		assertNotNull(findedItems);

	}

	@Test
	public void testFindItemByKeySearch_name() {
		when(itemRepository.findByName("name1")).thenReturn((itemList));
		List<Item> findedItems = itemService.findItemByKeySearch("name1");
		assertNotNull(findedItems);
	}

	@Test
	public void testFindItemByKeySearch_type() {
		when(itemRepository.findByType("type1")).thenReturn((itemList));
		List<Item> findedItems = itemService.findItemByKeySearch("type1");
		assertNotNull(findedItems);

	}

}
