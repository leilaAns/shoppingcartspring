package com.alithya.shoppingcard.entity;

import org.springframework.stereotype.Component;

@Component
public class Item implements Comparable<Item> {

	private int Id;
	private String name;
	private String type;
	private String des;

	public Item(int id, String name, String type, String des) {
		Id = id;
		this.name = name;
		this.type = type;
		this.des = des;
	}

	public Item() {

	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	@Override
	public String toString() {
		return "Item [Id=" + Id + ", name=" + name + ", type=" + type + ", des=" + des + "]";
	}

	@Override
	public int compareTo(Item o) {
		if (o.getId() == this.getId())
			return 0;
		else if (o.getId() < this.getId())
			return -1;
		else
			return 1;
	}

}
