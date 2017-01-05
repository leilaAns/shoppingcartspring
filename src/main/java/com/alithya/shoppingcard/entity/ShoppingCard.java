package com.alithya.shoppingcard.entity;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class ShoppingCard {

	private List<BuyableItem> buyableItemList;
	private double totalPrice;

	public ShoppingCard() {
		buyableItemList = new ArrayList<BuyableItem>();
	}

	public List<BuyableItem> getBuyableItemList() {
		return buyableItemList;
	}

	public void setBuyableItemList(List<BuyableItem> buyableItemList) {
		this.buyableItemList = buyableItemList;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "ShoppingCard [buyableItemList=" + buyableItemList + "]";
	}

}
