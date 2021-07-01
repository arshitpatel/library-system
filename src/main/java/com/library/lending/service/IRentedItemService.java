package com.library.lending.service;

import java.util.List;

import com.library.lending.model.RentedItem;

public interface IRentedItemService {

	public RentedItem rentItem(int itemId, long uid);

	public RentedItem returnItem(int itemId, long uid);

	public List<RentedItem> getAllRentedItems(long uid);

	public List<RentedItem> getAllOverdueRentedItems(long uid);

}
