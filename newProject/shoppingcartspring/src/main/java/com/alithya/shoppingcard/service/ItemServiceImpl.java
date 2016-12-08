package com.alithya.shoppingcard.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;
import com.alithya.shoppingcard.entity.BuyableItem;
import com.alithya.shoppingcard.entity.Item;

@Service
public class ItemServiceImpl implements ItemService {

	private List<Item> itemList;
	private ConcurrentHashMap<Integer, BuyableItem> mapCounts;

	public ItemServiceImpl() {
		this.itemList = new ArrayList<>();
		this.createList();
		mapCounts = new ConcurrentHashMap<Integer, BuyableItem>();

	}

	public Item createOneItem(int id, String name, String type, String des) {
		return new Item(id, name, type, des);
	}

	public List<Item> createList() {

		itemList.add(new Item(1, "name1", "type1", "des"));
		itemList.add(new Item(2, "name2", "type2", "des"));
		itemList.add(new Item(3, "name3", "type3", "des"));
		itemList.add(new Item(4, "name4", "type4", "des"));
		itemList.add(new Item(5, "name5", "type5", "des"));
		itemList.add(new Item(6, "name6", "type6", "des"));
		itemList.add(new Item(7, "name7", "type7", "des"));
		itemList.add(new Item(8, "name8", "type8", "des"));
		itemList.add(new Item(9, "name9", "type9", "des9"));
		return itemList;
	}

	public List<Item> findAll() {

		return this.itemList;
	}

	public Item find(int id) {
		Item findedItem = new Item();
		for (Item item : this.itemList) {
			if (item.getId() == id) {
				findedItem = item;
				break;
			}
		}
		return findedItem;

	}

	public void addNewItem(Item item) {
		try {
			if (item.getName() != null) {

				item.setId(this.itemList.get(itemList.size() - 1).getId() + 1);
				this.itemList.add(item);
			}

		} catch (Exception e) {
			System.out.println("this itme is null");
		}

	}

	public void editItem(int id, Item item) {
		this.deleteItem(id);
		this.itemList.add(item);
	}

	public void deleteItem(int id) {
		Item item = this.find(id);
		this.itemList.remove(item);
	}

	public List<Item> findByName(String name) {
		List<Item> list = new ArrayList<Item>();
		for (Item item : this.itemList) {
			if (item.getName().contains(name))
				list.add(item);
		}

		return list;
	}

	public List<Item> findByType(String type) {
		List<Item> list = new ArrayList<Item>();
		for (Item item : this.itemList) {
			if (item.getType().contains(type))
				list.add(item);
		}

		return list;
	}

	public List<Item> findByDescription(String des) {
		List<Item> list = new ArrayList<Item>();
		for (Item item : this.itemList) {
			if (item.getDes().contains(des))
				list.add(item);
		}

		return list;
	}

	public BuyableItem CreateBuyableItem(int id, int count) {
		BuyableItem buyableItem = new BuyableItem();
		Item item = this.find(id);
		buyableItem.setId(item.getId());
		buyableItem.setName(item.getName());
		buyableItem.setDes(item.getDes());
		buyableItem.setType(item.getType());
		buyableItem.setCount(count);
		return buyableItem;

	}

	private ConcurrentHashMap<Integer, BuyableItem> countBuyableCount(int id, BuyableItem buyableItme) {
		int count = 0;

		for (Entry<Integer, BuyableItem> entry : mapCounts.entrySet()) {

			if (id == entry.getKey()) {
				count = entry.getValue().getCount();
				count++;
				buyableItme = this.CreateBuyableItem(id, count);
				mapCounts.remove(id, buyableItme);
				mapCounts.put(id, buyableItme);
				count = 0;
			} else
				mapCounts.put(id, buyableItme);

		}

		return mapCounts;
	}

	private void putToMap(int id, BuyableItem buyableItem) {
		this.mapCounts.put(id, buyableItem);
	}

	public List<Item> findItemByKeySearch(String key) {
		HashSet<Item> itemSet = new HashSet<>();
		List<Item> findedItemslist = new ArrayList<Item>();
		if (key != "") {

			itemSet.addAll(this.findByName(key));
			itemSet.addAll(this.findByDescription(key));
			itemSet.addAll(this.findByType(key));

		}
		findedItemslist.addAll(itemSet);
		Collections.sort(findedItemslist);
		Collections.reverse(findedItemslist);
		return findedItemslist;

	}

	public List<BuyableItem> searchAndCountBuyableItemsInBasket(List<BuyableItem> buyableItemListInBasket, String[] selectedItemIds) {

		List<BuyableItem> temp = new ArrayList<BuyableItem>();
		List<BuyableItem> buyableList = new ArrayList<BuyableItem>();
		ConcurrentHashMap<Integer, BuyableItem> mapTemp = new ConcurrentHashMap<Integer, BuyableItem>();

		for (BuyableItem buyableItem : buyableItemListInBasket) {
			this.putToMap(buyableItem.getId(), buyableItem);

		}

		for (String id : selectedItemIds) {
			BuyableItem buyableItem = this.CreateBuyableItem(Integer.parseInt(id), 1);
			temp.add(buyableItem);
		}

		for (BuyableItem buyableItem : temp)
			mapTemp = this.countBuyableCount(buyableItem.getId(), buyableItem);

		for (Entry<Integer, BuyableItem> entry : mapTemp.entrySet())
			buyableList.add(entry.getValue());
		return buyableList;
	}

	public List<BuyableItem> updateBuyableItemsInBasket(String[] deletedItmeIds,
			List<BuyableItem> buyableItemsInBasket) {

		HashSet<String> itemIdsAsDeletedSet = new HashSet<>(Arrays.asList(deletedItmeIds));
		List<BuyableItem> temp = new ArrayList<>();

		for (BuyableItem buyableItem : buyableItemsInBasket) {
			for (String id : itemIdsAsDeletedSet)
				if (buyableItem.getId() == Integer.parseInt(id))
					temp.add(buyableItem);
		}

		buyableItemsInBasket.removeAll(temp);
		return buyableItemsInBasket;
	}
}
