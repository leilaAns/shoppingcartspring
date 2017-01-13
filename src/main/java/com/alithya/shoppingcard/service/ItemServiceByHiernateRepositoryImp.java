package com.alithya.shoppingcard.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alithya.shoppingcard.entity.BuyableItem;
import com.alithya.shoppingcard.entity.ShoppingCard;
import com.alithya.shoppingcard.persistence.ItemEntity;
import com.alithya.shoppingcard.repository.ItemRepository;





@Service
public class ItemServiceByHiernateRepositoryImp implements ItemService<ItemEntity>{

	@Autowired
	private ShoppingCard shoppingCard;
	
	@Autowired
	private ItemRepository<ItemEntity> itemRepository;
	
	List<BuyableItem> buyableItems = new ArrayList<BuyableItem>();
	List<ItemEntity> items = new ArrayList<>();
	
	@Override
	public List<ItemEntity> findAll() {
		
		return itemRepository.findAll();
	}

	@Override
	public ItemEntity find(int id) {
		
		return itemRepository.findById(id);
	}

	@Override
	public void addNewItem(ItemEntity item) {
		itemRepository.insert(item);
	}

	@Override
	public void editItem(ItemEntity item) {
		itemRepository.update(item);
		
	}

	@Override
	public void deleteItem(int id) {
		
		itemRepository.deleteItem(id);
	}

	@Override
	public List<ItemEntity> findByName(String name) {
		return itemRepository.findByName(name);
	}

	@Override
	public List<ItemEntity> findByType(String type) {
		return itemRepository.findByKey(type);
	}

	@Override
	public List<ItemEntity> findByDescription(String des) {
		return itemRepository.findByDescription(des);
	}

	@Override
	public List<ItemEntity> findItemByKeySearch(String key) {
		return itemRepository.findByKey(key);
	}

	@Override
	public List<BuyableItem> findBuyableItemsInBasket() {
		List<BuyableItem> buybleItmeInBasket = new ArrayList<BuyableItem>();
		double totalPrice = 0.0;
		for (BuyableItem buyableItem : shoppingCard.getBuyableItemList()) {
			if (buyableItem.getCount() != 0) {
				buybleItmeInBasket.add(buyableItem);
				totalPrice += buyableItem.getPrice()*buyableItem.getCount();
			}
		}

		shoppingCard.setTotalPrice(totalPrice);
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

		}
	}

	@Override
	public void CreateBuyableItemList() {
		for (ItemEntity item : items) {
			BuyableItem buyableItem = new BuyableItem();
			buyableItem.setId(item.getId());
			buyableItem.setName(item.getName());
			buyableItem.setType(item.getType());
			buyableItem.setDes(item.getDes());
			buyableItem.setCount(0);
			buyableItem.setPrice(item.getPrice());
			buyableItems.add(buyableItem);

		}
		shoppingCard.setBuyableItemList(buyableItems);
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
	public double getTotalPrice() {
		return shoppingCard.getTotalPrice();
	}

}
