package com.alithya.shoppingcard.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alithya.shoppingcard.entity.BuyableItem;
import com.alithya.shoppingcard.entity.Item;
import com.alithya.shoppingcard.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;

	public ItemServiceImpl() {

	}

	public List<Item> findAll() {

		return itemRepository.findAll();
	}

	public Item find(int id) {

		return itemRepository.findById(id);

	}

	public void addNewItem(Item item) {

		itemRepository.insert(item);
	}

	public void editItem(Item item) {

		itemRepository.update(item);
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

	@Override
	public BuyableItem findBuyableItemById(int id) {
		return itemRepository.findBuyableItemById(id);
	}

	@Override
	public void updateBuyableItemBycount(int id, int count) {
		itemRepository.updateBuyableItemBycount(id, count);

	}

	public List<Item> findItemByKeySearch(String key) {

		return itemRepository.findByKey(key);

	}

	@Override
	public void resetBuyableItemBycount() {

		itemRepository.resetBuyableItemCount();

	}

	@Override
	public List<BuyableItem> findAllBuyableItems() {

		return itemRepository.findAllBuyableItems();
	}

	@Override
	public void updateSelectedBuyableItemsCount(String[] selectedItemIds) {
		BuyableItem buyableItem = new BuyableItem();
		int count = 0;
		for (String id : selectedItemIds) {

			buyableItem = findBuyableItemById(Integer.parseInt(id));
			count = buyableItem.getCount();
			count += 1;
			updateBuyableItemBycount(Integer.parseInt(id), count);
			count = 0;

		}
	}

}
