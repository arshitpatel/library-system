package com.library.lending.dao;

import java.util.List;

import com.library.lending.model.RentedItem;

public interface IRentedItemRepository {

	public List<RentedItem> getRenteditemsForUser(long uid);

	public int addRentedItem(RentedItem item);
	
	public RentedItem removeRentedItem(long uid,int itemId);

}
