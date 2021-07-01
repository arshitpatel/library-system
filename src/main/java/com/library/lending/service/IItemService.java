package com.library.lending.service;

import com.library.lending.model.Item;

public interface IItemService {
	
	public Item getItem(int itemId);
	public Item createItem(Item item);
	
}
