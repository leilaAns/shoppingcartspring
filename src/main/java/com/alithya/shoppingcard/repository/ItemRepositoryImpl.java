package com.alithya.shoppingcard.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.alithya.shoppingcard.entity.Item;

@Repository
@Profile("prod")
public class ItemRepositoryImpl implements ItemRepository {

	private JdbcTemplate template;

	public ItemRepositoryImpl(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Item> findAll() {

		return null;
	}

	@Override
	public Item findById(int id) {

		return null;
	}

	@Override
	public List<Item> findByName(String name) {

		return null;
	}

	@Override
	public List<Item> findByType(String type) {

		return null;
	}

	@Override
	public List<Item> findByDescription(String des) {

		return null;
	}

	@Override
	public void deleteItem(int id) {

	}

	@Override
	public void update(int id, Item item) {

	}

}
