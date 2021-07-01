package com.library.lending.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.lending.dao.IItemRepository;
import com.library.lending.dao.IRentedItemRepository;
import com.library.lending.model.Item;
import com.library.lending.model.RentedItem;

@Component
public class RentedItemRepository implements IRentedItemRepository {

	private Map<Long, List<RentedItem>> rentedItems = new HashMap<Long, List<RentedItem>>();

	private final IItemRepository itemRepo;

	@Autowired
	public RentedItemRepository(IItemRepository itemRepo) {
		this.itemRepo = itemRepo;
	}

	public List<RentedItem> getRenteditemsForUser(long uid) {
		return rentedItems.get(uid);
	}

	public synchronized int addRentedItem(RentedItem item) {
		List<RentedItem> items = rentedItems.getOrDefault(item.getUserId(), new ArrayList<RentedItem>());
		items.add(item);
		rentedItems.put(item.getUserId(), items);
		return item.getItemId();
	}

	public synchronized RentedItem removeRentedItem(long uid, int itemId) {
		List<RentedItem> items = rentedItems.get(uid);
		RentedItem removed = null;
		for (RentedItem item : items) {
			if (item.getItemId() == itemId) {
				Item update = itemRepo.getItem(itemId);
				update.setAvailable(update.getAvailable() + 1);
				itemRepo.addOrUpdateItem(update);
				removed = item;
				items.remove(item);
				break;
			}
		}
		rentedItems.put(uid, items);
		return removed;
	}

}
