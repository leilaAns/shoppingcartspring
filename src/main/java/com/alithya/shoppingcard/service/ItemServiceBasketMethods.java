package com.alithya.shoppingcard.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.alithya.shoppingcard.entity.BuyableItem;
import com.alithya.shoppingcard.entity.Item;
import com.alithya.shoppingcard.entity.ShoppingCard;

@Profile("hibernate")
@Service
public  class ItemServiceBasketMethods{


	@Autowired
	private ShoppingCard shoppingCard;
	
	List<BuyableItem> buyableItems = new ArrayList<BuyableItem>();
	List<Item> items = new ArrayList<>();
	

	
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


	public void resetBuyableItemCount(String[] buyableItemIds) {

		for (String id : buyableItemIds) {
			for (BuyableItem buyableItem : shoppingCard.getBuyableItemList()) {
				if (buyableItem.getId() == Integer.parseInt(id)) {

					buyableItem.setCount(0);

				}
			}

		}

	}


	public void CreateBuyableItemList() {

		for (Item item : items) {
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


	public double getTotalPrice() {
		return shoppingCard.getTotalPrice();
	}

}
