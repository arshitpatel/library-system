package com.library.lending.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.lending.dao.IItemRepository;
import com.library.lending.model.Item;
import com.library.lending.service.IItemService;

@Component
public class ItemService implements IItemService{
	
	@Autowired
	private IItemRepository itemRepo;
	
	private static volatile int count = 1;

	public Item getItem(int itemId) {
		return itemRepo.getItem(itemId);
	}

	public synchronized Item createItem(Item obj) {
		Item item = new Item(count++, obj.getName(), obj.getTotalQty());
		itemRepo.addOrUpdateItem(item);
		return item;
	}

}
