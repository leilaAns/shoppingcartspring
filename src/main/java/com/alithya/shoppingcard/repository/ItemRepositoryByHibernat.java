package com.alithya.shoppingcard.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import com.alithya.shoppingcard.persistence.ItemEntity;


@Repository
public class ItemRepositoryByHibernat implements ItemRepository<ItemEntity> {

	@PersistenceContext
	EntityManager entityManager;



	public ItemRepositoryByHibernat() {
	}

	@Override
	public  List<ItemEntity> findAll() {
		
	    CriteriaQuery<ItemEntity> createQuery = entityManager.getCriteriaBuilder().createQuery(ItemEntity.class);
	    Root<ItemEntity> root = createQuery.from(ItemEntity.class);
	    createQuery.select(root);
	    return entityManager.createQuery(createQuery).getResultList();
	
	}

	@Override
	public  ItemEntity findById(int id) {
		Query query = entityManager.createNamedQuery("FIND_ITEM_BYID");
		query.setParameter("itemId", id);
		return  (ItemEntity) query.getResultList().get(0);
	}

	@Override
	public  List<ItemEntity> findByName(String name) {
		Query query = entityManager.createNamedQuery("FIND_ITEM_BYNMAE");
		query.setParameter("itemName", name);
		List<ItemEntity> resultList = (List<ItemEntity>)query.getResultList();
		return resultList;

	}

	@Override
	public  List<ItemEntity> findByType(String type) {
		Query query = entityManager.createNamedQuery("FIND_ITEM_BYTYPE");
		query.setParameter("itemType", type);
		return query.getResultList();
	}

	@Override
	public  List<ItemEntity> findByDescription(String des) {
		Query query = entityManager.createNamedQuery("FIND_ITEM_BYDESCRIPTION");
		query.setParameter("itemDes", des);
		return query.getResultList();
	}

	@Override
	public  List<ItemEntity> findByKey(String key) {
		Query query = entityManager.createNamedQuery("FIND_TIEM_BYKEY");
		query.setParameter("key", key);
		return query.getResultList();
	}
	
	@Override
	public int deleteItem(int id) {
		ItemEntity itemEntity = entityManager.find(ItemEntity.class, id);
		entityManager.remove(itemEntity);
		return 0;
	}

	@Override
	public int update(ItemEntity item) {
//		Query query = entityManager.createNamedQuery("UPDATE_ITEM");
//		query.setParameter("itemId", item.getId());
//		query.setParameter("itemName", item.getName());
//		query.setParameter("itemType", item.getType());
//		query.setParameter("itemDes", item.getDes());
//		query.setParameter("itemPrice", item.getPrice());
//		entityManager.
		return 0;
	}

	@Override
	public int insert(ItemEntity item) {
		entityManager.persist(item);
		return 0;
	}

}
