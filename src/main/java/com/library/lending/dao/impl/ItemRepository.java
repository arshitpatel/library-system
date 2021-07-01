package com.library.lending.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.library.lending.dao.IItemRepository;
import com.library.lending.model.Item;

@Component
public class ItemRepository implements  IItemRepository{
	
	private Map<Integer, Item> items = new HashMap<Integer, Item>();
	
	public Item getItem(int itemId) {
		return items.get(itemId);
	}
	
	public synchronized int addOrUpdateItem(Item item) {
		items.put(item.getItemId(), item);
		return item.getItemId();
	}
}
