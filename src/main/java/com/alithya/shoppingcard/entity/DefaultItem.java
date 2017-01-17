package com.alithya.shoppingcard.entity;

import org.springframework.stereotype.Component;

@Component
public class DefaultItem {
	private int Id;
	private String name;
	private String type;
	private String des;
	private double price;
	
	public DefaultItem(int id, String name, String type, String des, double price) {
		Id = id;
		this.name = name;
		this.type = type;
		this.des = des;
		this.price = price;
	}
	
	public DefaultItem() {
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
