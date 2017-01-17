package com.alithya.shoppingcard.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.alithya.shoppingcard.entity.DefaultItem;
import com.alithya.shoppingcard.persistence.ItemEntity;
import com.alithya.shoppingcard.repository.ItemRepository;





@Service(value = "itemService")
@Profile("hibernate")
public class ItemServiceByHiernateRepositoryImp  implements ItemService<ItemEntity>{

	
	@Autowired
	private ItemRepository<ItemEntity> itemRepository;

	
	@Override
	public List<ItemEntity> findAll() {
		
		return itemRepository.findAll();
	}

	@Override
	public ItemEntity find(int id) {
		
		return itemRepository.findById(id);
	}


	@Override
	public void deleteItem(int id) {
		
		itemRepository.deleteItem(id);
	}

	@Override
	public List<ItemEntity> findByName(String name) {
		return itemRepository.findByName(name);
	}

	@Override
	public List<ItemEntity> findByType(String type) {
		return itemRepository.findByKey(type);
	}

	@Override
	public List<ItemEntity> findByDescription(String des) {
		return itemRepository.findByDescription(des);
	}

	@Override
	public List<ItemEntity> findItemByKeySearch(String key) {
		return itemRepository.findByKey(key);
	}

	@Override
	public ItemEntity createItem() {
		return new ItemEntity();
	}

	@Override
	public void editItem(DefaultItem defaultItem) {
	
		itemRepository.update(setItemEntityProperites(defaultItem));
	}

	@Override
	public void addNewItem(DefaultItem defaultItem) {

	
		itemRepository.insert(setItemEntityProperites(defaultItem));
		
	}
	
	private DefaultItem setItemEntityProperites(DefaultItem defaultItem){
		DefaultItem itemEntity = new ItemEntity();
		itemEntity.setDes(defaultItem.getDes());
		itemEntity.setId(defaultItem.getId());
		itemEntity.setName(defaultItem.getName());
		itemEntity.setPrice(defaultItem.getPrice());
		itemEntity.setType(defaultItem.getType());
		return itemEntity;
	}

}
