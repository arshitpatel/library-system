package com.library.lending.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.lending.model.Item;
import com.library.lending.service.IItemService;

@RestController
@RequestMapping(value = "/item")
public class ItemController {

	private final IItemService service;

	@Autowired
	public ItemController(IItemService service) {
		this.service = service;
	}

	@GetMapping(value = "/{itemId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Item> rentItem(@PathVariable(value = "itemId") int itemId) {

		return new ResponseEntity<Item>(service.getItem(itemId), HttpStatus.OK);
	}
	
	@PostMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Item> createItem(@RequestBody Item item) {

		return new ResponseEntity<Item>(service.createItem(item), HttpStatus.OK);
	}

}
