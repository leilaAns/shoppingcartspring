package com.alithya.shoppingcard.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;




@Entity
@Table(name = "item_table")
@NamedQueries({@NamedQuery(name = "FIND_ITEM_BYID",query = "select i from item_table i where id = :itemId"),
	@NamedQuery(name = "FIND_ITEM_BYNMAE",query = "select i from item_table i where name like :itemName"),
	@NamedQuery(name = "FIND_ITEM_BYTYPE",query = "select i from item_table i where type like :itemType"),
	@NamedQuery(name = "FIND_ITEM_BYDESCRIPTION",query = "select i from item_table i where description like :itemDes"),
	@NamedQuery(name = "FIND_TIEM_BYKEY",query = "select * from item_table where name like :key or type like :key or description like :key"),
	@NamedQuery(name = "UPDATE_ITEM",query = "update item_table set name = :itemName , type = :itemType , description = :itemDes where id = :itemId")})
public class ItemEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name= "name")
	private String name;
	
	@Column(name = "type")
	private String type;
	
	@Column(name= "description")
	private String des;
	
	@Column(name = "price")
	private double price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
