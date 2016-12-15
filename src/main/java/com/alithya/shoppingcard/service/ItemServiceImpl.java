package com.alithya.shoppingcard.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alithya.shoppingcard.entity.BuyableItem;
import com.alithya.shoppingcard.entity.Item;
import com.alithya.shoppingcard.entity.ShoppingCard;
import com.alithya.shoppingcard.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private ShoppingCard shoppingCard;

	List<Item> items = new ArrayList<>();
	List<BuyableItem> buyableItems = new ArrayList();

	public ItemServiceImpl() {

	}

	public List<Item> findAll() {

		items = itemRepository.findAll();
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
	public List<BuyableItem> findBuyableItemsInBasket() {

		List<BuyableItem> buybleItmeInBasket = new ArrayList<BuyableItem>();
		for (BuyableItem buyableItem : shoppingCard.getBuyableItemList()) {
			if (buyableItem.getCount() != 0) {
				buybleItmeInBasket.add(buyableItem);
			}
		}
		return buybleItmeInBasket;
	}


	@Override
	public void updateShoppingCard(String[] itemIds) {

		int count = 0;
		for (String id : itemIds) {
			for (BuyableItem buyableItem : shoppingCard.getBuyableItemList()) {
				if (buyableItem.getId() == Integer.parseInt(id)) {

					count = buyableItem.getCount();
					count += 1;
					buyableItem.setCount(count);

				}
			}
			updateBuyableItemBycount(Integer.parseInt(id), count);

		}

	}

	@Override
	public void resetBuyableItemCount(String[] buyableItemIds) {

		for (String id : buyableItemIds) {
			for (BuyableItem buyableItem : shoppingCard.getBuyableItemList()) {
				if (buyableItem.getId() == Integer.parseInt(id)) {

					buyableItem.setCount(0);

				}
			}

		}

	}

	@Override
	public void CreateBuyableItemList() {

		for (Item item : items) {
			BuyableItem buyableItem = new BuyableItem();
			buyableItem.setId(item.getId());
			buyableItem.setName(item.getName());
			buyableItem.setType(item.getType());
			buyableItem.setDes(item.getDes());
			buyableItem.setCount(0);
			buyableItems.add(buyableItem);

		}
		shoppingCard.setBuyableItemList(buyableItems);

	}

}
