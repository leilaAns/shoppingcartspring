package com.alithya.shoppingcard.service;

import java.util.List;

import com.alithya.shoppingcard.entity.DefaultItem;






public interface ItemService<T> {

	public  List<T> findAll();

	public  T find(int id);

	public  void editItem(DefaultItem defaultItem);

	public void deleteItem(int id);

	public  List<T> findByName(String name);

	public  List<T> findByType(String type);

	public  List<T> findByDescription(String des);

	public  List<T> findItemByKeySearch(String key);
	
	public T createItem();

	public void addNewItem(DefaultItem defaultItem);

	



}
