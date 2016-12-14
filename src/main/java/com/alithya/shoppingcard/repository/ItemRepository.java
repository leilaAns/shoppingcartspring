package com.alithya.shoppingcard.repository;

import java.util.List;
import com.alithya.shoppingcard.entity.BuyableItem;
import com.alithya.shoppingcard.entity.Item;

public interface ItemRepository {

	public List<Item> findAll();

	public List<BuyableItem> findAllBuyableItems();

	public Item findById(int id);

	public BuyableItem findBuyableItemById(int id);

	public List<Item> findByName(String name);

	public List<Item> findByType(String type);

	public List<Item> findByDescription(String des);

	public int deleteItem(int id);

	public int update(Item item);

	public int insert(Item item);

	public int updateBuyableItemBycount(int id, int count);

	public int resetBuyableItemCount();

	public List<Item> findByKey(String key);

}
