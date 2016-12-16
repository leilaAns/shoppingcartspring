package com.alithya.shoppingcard.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class ShoppingCard {
	
	private List<BuyableItem> buyableItemList;
	
	
	public ShoppingCard() {
		buyableItemList = new ArrayList<>();
	}

	public List<BuyableItem> getBuyableItemList() {
		return buyableItemList;
	}

	public void setBuyableItemList(List<BuyableItem> buyableItemList) {
		this.buyableItemList = buyableItemList;
	}
	
	@Override
	public String toString() {
		return "ShoppingCard [buyableItemList=" + buyableItemList + "]";
	}
	

}
