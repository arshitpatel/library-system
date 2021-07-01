package com.library.lending.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.lending.dao.IItemRepository;
import com.library.lending.dao.IRentedItemRepository;
import com.library.lending.exception.OperationNotAllowed;
import com.library.lending.model.Item;
import com.library.lending.model.RentedItem;
import com.library.lending.service.IRentedItemService;

@Component
public class RentedItemService implements IRentedItemService{
	
	private final IRentedItemRepository rentedItemRepo;
	
	private final IItemRepository itemRepo;
	
	@Autowired
	public RentedItemService(IRentedItemRepository rentedItemRepo, IItemRepository itemRepo) {
		this.rentedItemRepo =rentedItemRepo;
		this.itemRepo = itemRepo;
	}

	public synchronized RentedItem rentItem(int itemId, long uid) {
			Item item = itemRepo.getItem(itemId);
			if(item.getAvailable() > 0 && item != null) {
				RentedItem rented  = new RentedItem(uid, itemId);
				rentedItemRepo.addRentedItem(rented);
				item.setAvailable(item.getAvailable() - 1);
				itemRepo.addOrUpdateItem(item);
				return rented;
			}else {
				throw new OperationNotAllowed("Operation not allowd. Check availibility status before renting");
			}
	}

	public RentedItem returnItem(int itemId, long uid) {
		Item item = itemRepo.getItem(itemId);
		RentedItem removed = null;
		if(item != null) {
			removed = rentedItemRepo.removeRentedItem(uid, itemId);
			item.setAvailable(item.getAvailable() - 1);
			itemRepo.addOrUpdateItem(item);
			return removed;
		}else {
			throw new OperationNotAllowed("Operation not allowd. Check availibility status before returning it");
		}
	}

	public List<RentedItem> getAllRentedItems(long uid) {
		return rentedItemRepo.getRenteditemsForUser(uid);
	}

	public List<RentedItem> getAllOverdueRentedItems(long uid) {
		List<RentedItem> allItems = rentedItemRepo.getRenteditemsForUser(uid);
		List<RentedItem> dueItems  = new ArrayList<RentedItem>();
		Date current = new Date();
		for(RentedItem item : allItems) {
			if(item.getDueDate().getTime() < current.getTime()) {
				dueItems.add(item);
			}
		}
		return dueItems;
	}

}
