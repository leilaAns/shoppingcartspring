package com.alithya.shoppingcard.service;

import java.util.List;
import com.alithya.shoppingcard.entity.BuyableItem;


public interface ItemService<T> {

	public  List<T> findAll();

	public  T find(int id);

	public  void addNewItem(T item);

	public  void editItem(T item);

	public void deleteItem(int id);

	public  List<T> findByName(String name);

	public  List<T> findByType(String type);

	public  List<T> findByDescription(String des);

	public  List<T> findItemByKeySearch(String key);

	public List<BuyableItem> findBuyableItemsInBasket();

	public void updateShoppingCard(String[] itemIds);

	public void CreateBuyableItemList();

	public void resetBuyableItemCount(String[] buyableItemIds);
	
	public double getTotalPrice();

}
