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
import com.alithya.shoppingcard.configuration.PersistenceJPAConfig;
import com.alithya.shoppingcard.entity.DefaultItem;
import com.alithya.shoppingcard.persistence.ItemEntity;
import com.alithya.shoppingcard.repository.ItemRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceJPAConfig.class)
@Transactional
@ActiveProfiles({"test", "hibernate"})
public class ItemRepositoryByHibernatTest {

	@Autowired
	private ItemRepository<ItemEntity> itemRepository ;
	
	@Test
	public void testFindAll() {
		List<ItemEntity> items = itemRepository.findAll();
		assertEquals(items.size(), 10);
	}
	@Test
	public void testFindById() {
		ItemEntity item = itemRepository.findById(1);
		assertNotNull(item);
		assertEquals(item.getId(), 1);
	}
	
	@Test
	public void testFindByName() {
		List<ItemEntity> items = itemRepository.findByName("name1");
		assertEquals(items.size(), 1);
		assertEquals(items.get(0).getName(), "name1");

	}

	@Test
	public void testFindByType() {
		List<ItemEntity> items = itemRepository.findByType("type1");
		assertEquals(items.size(), 1);
		assertEquals(items.get(0).getType(), "type1");
	}

	@Test
	public void testFindByDescription() {
		List<ItemEntity> items = itemRepository.findByDescription("des1");
		assertEquals(items.size(), 1);
		assertEquals(items.get(0).getDes(), "des1");
	}

	@Test
	public void testFindByKeyIfKeyIsName() {
		List<ItemEntity> items = itemRepository.findByKey("name1");
		assertEquals(items.size(), 1);
		assertEquals(items.get(0).getName(), "name1");
	}

	@Test
	public void testFindByKeyIfKeyIsType() {
		List<ItemEntity> items = itemRepository.findByKey("type1");
		assertEquals(items.size(), 1);
		assertEquals(items.get(0).getType(), "type1");
	}

	@Test
	public void testFindByKeyIfKeyIsDescription() {
		List<ItemEntity> items = itemRepository.findByKey("des1");
		assertEquals(items.size(), 1);
		assertEquals(items.get(0).getDes(), "des1");
	}

	@Test
	public void testInsert() {
		DefaultItem  itemEntity = new ItemEntity();
		itemEntity.setDes("des11");
		itemEntity.setName("name11");
		itemEntity.setType("type11");
		itemEntity.setPrice(20.00);
		int id = itemRepository.insert(itemEntity);
		assertNotNull(id);

	}

	@Test
	public void testUpdate() {
		ItemEntity item = itemRepository.findById(1);
		item.setName("newName");
		item.setType("newType");
		item.setDes("newDes");
		itemRepository.update(item);
		ItemEntity updatedItem = itemRepository.findById(1);
		assertEquals(updatedItem.getName(), "newName");
		assertEquals(updatedItem.getType(), "newType");
		assertEquals(updatedItem.getDes(), "newDes");
	}

}
