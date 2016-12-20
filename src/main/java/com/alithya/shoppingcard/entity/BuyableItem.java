package com.alithya.shoppingcard.entity;

import org.springframework.stereotype.Component;

@Component
public class BuyableItem extends Item{
	
	private int count = 0;
	
	
	
	public BuyableItem(int id, String name, String type, String des,double price ,int count) {
		super(id,name,type,des,price);
		this.count = count;
	}

	public BuyableItem() {
		
	}

	public  int getCount() {
		return count;
	}

	public  void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return super.toString() +"BuyableItem [count=" + count + "]";
	}
	
}
