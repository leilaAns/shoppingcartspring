package com.alithya.shoppingcard.repository;

import java.util.List;

import com.alithya.shoppingcard.entity.DefaultItem;


public interface ItemRepository<T> {

	public  List<T> findAll();

	public  T findById(int id);

	public  List<T> findByName(String name);

	public  List<T> findByType(String type);

	public  List<T> findByDescription(String des);

	public int deleteItem(int id);

	public  int update(DefaultItem defaulItem);

	public  int insert(DefaultItem defaulItem);

	public  List<T> findByKey(String key);

}
