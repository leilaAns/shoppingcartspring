package com.alithya.shoppingcard.service;

import java.util.List;
import com.alithya.shoppingcard.entity.BuyableItem;
import com.alithya.shoppingcard.entity.Item;

public interface ItemService {

	public List<Item> findAll();

	public Item find(int id);

	public void addNewItem(Item item);

	public void editItem(Item item);

	public void deleteItem(int id);

	public List<Item> findByName(String name);

	public List<Item> findByType(String type);

	public List<Item> findByDescription(String des);

	public List<Item> findItemByKeySearch(String key);

	public List<BuyableItem> findBuyableItemsInBasket();

	public void updateShoppingCard(String[] itemIds);

	public void CreateBuyableItemList();

	public void resetBuyableItemCount(String[] buyableItemIds);
	
	public double getTotalPrice();

}
