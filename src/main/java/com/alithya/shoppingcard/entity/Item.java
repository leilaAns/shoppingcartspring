package com.alithya.shoppingcard.entity;

import org.springframework.stereotype.Component;

@Component
public class Item extends DefaultItem {

	public Item(int id, String name, String type, String des, double price) {
		super(id, name, type, des, price);
	}

	public Item() {
		super();
	}
}
