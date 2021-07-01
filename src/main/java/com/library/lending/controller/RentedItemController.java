package com.library.lending.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.lending.model.RentedItem;
import com.library.lending.service.IRentedItemService;

@RestController
@RequestMapping(value = "/rent")
public class RentedItemController {

	private final IRentedItemService service;

	@Autowired
	public RentedItemController(IRentedItemService service) {
		this.service = service;
	}

	@PutMapping(value = "/item/{itemId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<RentedItem> rentItem(@PathVariable(value = "itemId") int itemId,
			@RequestParam(value = "uid") long uid) {

		return new ResponseEntity<RentedItem>(service.rentItem(itemId, uid), HttpStatus.OK);
	}

	@PutMapping(value = "/return/{itemId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<RentedItem> returnItem(@PathVariable(value = "itemId") int itemId,
			@RequestParam(value = "uid") long uid) {

		return new ResponseEntity<RentedItem>(service.returnItem(itemId, uid), HttpStatus.OK);
	}

	@GetMapping(value = "/items/{uid}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<RentedItem>> getAllRentedItems(@PathVariable(value = "uid") long uid) {

		return new ResponseEntity<List<RentedItem>>(service.getAllRentedItems(uid), HttpStatus.OK);
	}
	
	@GetMapping(value = "/items/overdue/{uid}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<RentedItem>> getAllOverDueRentedItems(@PathVariable(value = "uid") long uid) {

		return new ResponseEntity<List<RentedItem>>(service.getAllOverdueRentedItems(uid), HttpStatus.OK);
	}

}
