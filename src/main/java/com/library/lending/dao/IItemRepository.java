package com.library.lending.dao;

import com.library.lending.model.Item;

public interface IItemRepository {

	public Item getItem(int itemId);

	public int addOrUpdateItem(Item item);
}
