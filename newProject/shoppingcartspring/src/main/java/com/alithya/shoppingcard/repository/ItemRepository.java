package com.alithya.shoppingcard.repository;

import java.util.List;
import com.alithya.shoppingcard.entity.Item;

public interface ItemRepository {

	public List<Item> findAll();

	public Item findById(int id);

	public List<Item> findByName(String name);

	public List<Item> findByType(String type);

	public List<Item> findByDescription(String des);

	public void deleteItem(int id);

	public void update(int id, Item item);

}
