package com.alithya.shoppingcard.test.repository;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.alithya.shoppingcard.configuration.MyDataSourceConfig;
import com.alithya.shoppingcard.entity.BuyableItem;
import com.alithya.shoppingcard.entity.Item;
import com.alithya.shoppingcard.repository.ItemRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MyDataSourceConfig.class)
@Transactional
@ActiveProfiles("test")
public class ItemRepositoryImplTest {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Test
	public void testFindAll(){
		List<Item> items = itemRepository.findAll();
		assertEquals(items.size(), 10);
	}

	@Test
	public void testFindAllBuyableItems(){
		List<BuyableItem> buyableItems = itemRepository.findAllBuyableItems();
		assertEquals(buyableItems.size(), 1);
	}
	
	@Test
	public void testFindById(){
		Item item = itemRepository.findById(1);
		assertNotNull(item);
		assertEquals(item.getId(), 1);
	}

	@Test
	public void testFindBuyableItemById(){
		BuyableItem buyableItem = itemRepository.findBuyableItemById(10);
		assertNotNull(buyableItem);
		assertEquals(buyableItem.getId(), 10);
		
	}
	
	@Test
	public void testFindByName(){
		List<Item> items = itemRepository.findByName("name1");
		assertEquals(items.size(), 1);
		assertEquals(items.get(0).getName(), "name1");
		
	}
	
	@Test
	public void testFindByType(){
		List<Item> items = itemRepository.findByType("type1");
		assertEquals(items.size(), 1);
		assertEquals(items.get(0).getType(), "type1");
	}
	
	@Test
	public void testFindByDescription(){
		List<Item> items = itemRepository.findByDescription("des1");
		assertEquals(items.size(), 1);
		assertEquals(items.get(0).getDes(), "des1");
	}
	
	@Test
	public void testFindByKeyIfKeyIsName(){
		List<Item> items = itemRepository.findByKey("name1");
		assertEquals(items.size(), 1);
		assertEquals(items.get(0).getName(), "name1");
	}
	
	@Test
	public void testFindByKeyIfKeyIsType(){
		List<Item> items = itemRepository.findByKey("type1");
		assertEquals(items.size(), 1);
		assertEquals(items.get(0).getType(), "type1");
	}
	
	@Test
	public void testFindByKeyIfKeyIsDescription(){
		List<Item> items = itemRepository.findByKey("des1");
		assertEquals(items.size(), 1);
		assertEquals(items.get(0).getDes(), "des1");
	}
	
	@Test
	public void testInsert(){
		int id = itemRepository.insert(new Item(11,"name11","type11","des11"));
		assertNotNull(id);
	
	}
	
	@Test
	public void testUpdate(){
		Item item = itemRepository.findById(1);
		item.setName("newName");
		item.setType("newType");
		item.setDes("newDes");
		itemRepository.update(item);
		Item updatedItem = itemRepository.findById(1);
		assertEquals(updatedItem.getName(), "newName");
		assertEquals(updatedItem.getType(), "newType");
		assertEquals(updatedItem.getDes(), "newDes");
	}
	
	@Test
	public void testUpdateBuyableItemBycount(){
		itemRepository.updateBuyableItemBycount(10, 10);
		BuyableItem newBuyableItem = itemRepository.findBuyableItemById(10);
		assertEquals(newBuyableItem.getCount(), 10);
	}
	
	@Test
	public void testResetBuyableItemCount(){
		itemRepository.resetBuyableItemCount();
		BuyableItem buyableItem = itemRepository.findBuyableItemById(10);
		assertEquals(buyableItem.getCount(), 0);
	}
}
