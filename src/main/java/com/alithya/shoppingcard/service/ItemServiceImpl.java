package com.alithya.shoppingcard.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import com.alithya.shoppingcard.entity.BuyableItem;
import com.alithya.shoppingcard.entity.Item;
import com.alithya.shoppingcard.entity.ShoppingCard;
import com.alithya.shoppingcard.repository.ItemRepository;

@Service(value = "itemService")
@Profile("jdbc")
public class ItemServiceImpl implements ItemService<Item> {

	@Autowired
	private ItemRepository<Item> itemRepository;

	@Autowired
	private ShoppingCard shoppingCard;

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


	@Override
	public  void addNewItem(Item item) {
		
		itemRepository.insert(item);	
	}

	@Override
	public  void editItem(Item item) {
		
		itemRepository.update(item);
		
	}

}
