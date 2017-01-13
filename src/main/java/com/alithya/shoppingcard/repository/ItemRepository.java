package com.alithya.shoppingcard.repository;

import java.util.List;


public interface ItemRepository<T> {

	public  List<T> findAll();

	public  T findById(int id);

	public  List<T> findByName(String name);

	public  List<T> findByType(String type);

	public  List<T> findByDescription(String des);

	public int deleteItem(int id);

	public  int update(T item);

	public  int insert(T item);

	public  List<T> findByKey(String key);

}
