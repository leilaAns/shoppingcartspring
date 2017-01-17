package com.alithya.shoppingcard.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import com.alithya.shoppingcard.entity.BuyableItem;
import com.alithya.shoppingcard.entity.DefaultItem;
import com.alithya.shoppingcard.entity.Item;
import com.alithya.shoppingcard.persistence.ItemEntity;
import com.alithya.shoppingcard.repository.ItemRepository;

@Service(value = "itemService")
@Profile("jdbc")
public class ItemServiceImpl implements ItemService<Item> {

	@Autowired
	private ItemRepository<Item> itemRepository;

	List<Item> items = new ArrayList<>();
	List<BuyableItem> buyableItems = new ArrayList<BuyableItem>();

	public ItemServiceImpl() {

	}

	public List<Item> findAll() {

		items = itemRepository.findAll();
		return itemRepository.findAll();
	}

	public Item find(int id) {

		return itemRepository.findById(id);

	}

	public void deleteItem(int id) {
		itemRepository.deleteItem(id);
	}

	public List<Item> findByName(String name) {
		return itemRepository.findByName(name);
	}

	public List<Item> findByType(String type) {
		return itemRepository.findByType(type);
	}

	public List<Item> findByDescription(String des) {
		return itemRepository.findByDescription(des);
	}

	
	public List<Item> findItemByKeySearch(String key) {

		return itemRepository.findByKey(key);

	}

//
//
//	@Override
//	public void addNewItem(Object item) {
//		itemRepository.insert(item);	
//	}
//
//	@Override
//	public void editItem(Object item) {
//		itemRepository.update(item);
//	}

	@Override
	public Item createItem() {
		return new Item();
	}



	@Override
	public void editItem(DefaultItem defaultItem) {

		itemRepository.update(setItemProperites(defaultItem));
	}

	@Override
	public void addNewItem(DefaultItem defaultItem) {
	
		itemRepository.insert(setItemProperites(defaultItem));	
		
	}
	
	private DefaultItem setItemProperites(DefaultItem defaultItem){
		DefaultItem item = new Item();
		item.setDes(defaultItem.getDes());
		item.setId(defaultItem.getId());
		item.setName(defaultItem.getName());
		item.setPrice(defaultItem.getPrice());
		item.setType(defaultItem.getType());
		return item;
	}
	

}
