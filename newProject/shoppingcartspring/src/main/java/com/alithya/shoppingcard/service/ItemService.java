package com.alithya.shoppingcard.service;

import java.util.List;
import com.alithya.shoppingcard.entity.BuyableItem;
import com.alithya.shoppingcard.entity.Item;

public interface ItemService {

	public List<Item> createList();

	public Item createOneItem(int id, String name, String type, String des);

	public List<Item> findAll();

	public Item find(int id);

	public void addNewItem(Item item);

	public void editItem(int id, Item item);

	public void deleteItem(int id);

	public List<Item> findByName(String name);

	public List<Item> findByType(String type);

	public List<Item> findByDescription(String des);

	public List<Item> findItemByKeySearch(String key);

	public BuyableItem CreateBuyableItem(int id, int count);

	public List<BuyableItem> searchAndCountBuyableItemsInBasket(List<BuyableItem> attribute, String[] parameterValues);

	public List<BuyableItem> updateBuyableItemsInBasket(String[] parameterValues, List<BuyableItem> attribute);

}
