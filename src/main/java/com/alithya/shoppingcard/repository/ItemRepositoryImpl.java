package com.alithya.shoppingcard.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.alithya.shoppingcard.entity.DefaultItem;
import com.alithya.shoppingcard.entity.Item;


@Repository
public class ItemRepositoryImpl implements ItemRepository<Item> {

	public static final String FIND_ALLITEMS = "select * from item_table";
	public static final String FIND_ITEM_BYID = "select * from item_table where id = :itemId";
	public static final String FIND_ITEM_BYNMAE = "select * from item_table where name like :itemName";
	public static final String FIND_ITEM_BYTYPE = "select * from item_table where type like :itemType";
	public static final String FIND_ITEM_BYDESCRIPTION = "select * from item_table where description like :itemDes";
	public static final String DELETE_ITEM = "delete from item_table where id = :itemId";
	public static final String INSERT_ITEM = "insert into item_table values(:itemId,:itemName,:itemType,:itemDes,:itemPrice)";
	public static final String UPDATE_ITEM = "update item_table set name = :itemName , type = :itemType , description = :itemDes where id = :itemId";
	public static final String FIND_TIEM_BYKEY = "select * from item_table where name like :key or type like :key or description like :key";

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private SqlParameterSource namedParameters;
	private Map<String, Object> namedParametersMap;

	@Autowired
	public ItemRepositoryImpl(DataSource dataSource) {

		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		namedParametersMap = new HashMap<>();

	}

	@Override
	public List<Item> findAll() {
		return namedParameterJdbcTemplate.query(FIND_ALLITEMS, new ItemMapper());
	}

	@Override
	public Item findById(int id) {

		namedParameters = new MapSqlParameterSource("itemId", id);
		return namedParameterJdbcTemplate.queryForObject(FIND_ITEM_BYID, namedParameters, new ItemMapper());

	}


	@Override
	public List<Item> findByName(String name) {
		namedParameters = new MapSqlParameterSource("itemName", name);
		return namedParameterJdbcTemplate.query(FIND_ITEM_BYNMAE, namedParameters, new ItemMapper());
	}

	@Override
	public List<Item> findByType(String type) {

		namedParameters = new MapSqlParameterSource("itemType", type);
		return namedParameterJdbcTemplate.query(FIND_ITEM_BYTYPE, namedParameters, new ItemMapper());

	}

	@Override
	public List<Item> findByDescription(String des) {

		namedParameters = new MapSqlParameterSource("itemDes", des);
		return namedParameterJdbcTemplate.query(FIND_ITEM_BYDESCRIPTION, namedParameters, new ItemMapper());

	}

	@Override
	public List<Item> findByKey(String key) {
		namedParameters = new MapSqlParameterSource("key", key);
		return namedParameterJdbcTemplate.query(FIND_TIEM_BYKEY, namedParameters, new ItemMapper());

	}

	@Override
	public int deleteItem(int id) {

		namedParameters = new MapSqlParameterSource("itemId", id);
		return namedParameterJdbcTemplate.update(DELETE_ITEM, namedParameters);

	}

	private class ItemMapper implements RowMapper<Item> {

		@Override
		public Item mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
			return new Item(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("type"),
					resultSet.getString("description"), resultSet.getDouble("price"));
		}

	}


	@Override
	public int update(DefaultItem item) {
		namedParametersMap.put("itemName", ((com.alithya.shoppingcard.entity.Item) item).getName());
		namedParametersMap.put("itemType", ((com.alithya.shoppingcard.entity.Item) item).getType());
		namedParametersMap.put("itemDes", ((com.alithya.shoppingcard.entity.Item) item).getDes());
		namedParametersMap.put("itemId", ((com.alithya.shoppingcard.entity.Item) item).getId());
		return namedParameterJdbcTemplate.update(UPDATE_ITEM, namedParametersMap);
		
	}

	@Override
	public int insert(DefaultItem item) {
		namedParametersMap.put("itemId", ((com.alithya.shoppingcard.entity.Item) item).getId());
		namedParametersMap.put("itemName", ((com.alithya.shoppingcard.entity.Item)item).getName());
		namedParametersMap.put("itemType", ((com.alithya.shoppingcard.entity.Item)item).getType());
		namedParametersMap.put("itemDes", ((com.alithya.shoppingcard.entity.Item)item).getDes());
		namedParametersMap.put("itemCount", 0);
		namedParametersMap.put("itemPrice", ((com.alithya.shoppingcard.entity.Item)item).getPrice());
		return namedParameterJdbcTemplate.update(INSERT_ITEM, namedParametersMap);
	}




}
