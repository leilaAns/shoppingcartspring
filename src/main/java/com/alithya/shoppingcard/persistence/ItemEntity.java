package com.alithya.shoppingcard.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.alithya.shoppingcard.entity.DefaultItem;




@Entity
@Table(name = "item_table")
@NamedQueries({@NamedQuery(name = "FIND_ITEM_BYID",query = "select i from ItemEntity i where id = :itemId"),
	@NamedQuery(name = "FIND_ITEM_BYNMAE",query = "select i from ItemEntity i where i.name like :itemName"),
	@NamedQuery(name = "FIND_ITEM_BYTYPE",query = "select i from ItemEntity i where i.type like :itemType"),
	@NamedQuery(name = "FIND_ITEM_BYDESCRIPTION",query = "select i from ItemEntity i where i.des like :itemDes"),
	@NamedQuery(name = "FIND_TIEM_BYKEY",query = "select i from ItemEntity i where i.name like :key or i.type =:key or i.des =:key")
})
public class ItemEntity extends DefaultItem implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6852553612988511346L;

	public ItemEntity() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@Override
	public int getId() {
		return super.getId();
	}

	@Column(name= "name")
	@Override
	public String getName() {
		return super.getName();
	}

	@Column(name = "type")
	@Override
	public String getType() {
		return super.getType();
	}

	@Column(name= "description")
	@Override
	public String getDes() {
		return super.getDes();
	}

	@Column(name = "price")
	@Override
	public double getPrice() {
		return super.getPrice();
	}
}
