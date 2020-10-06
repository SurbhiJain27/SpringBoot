package com.egen.controller;

import com.egen.entity.Item;
import com.egen.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/* /ecommerce/item/create: to create data in item table.
   /ecommerce/item/{orderId}: to fetch data from item table.*/

@RestController
@RequestMapping("/ecommerce/item")
public class ItemController {

    @Autowired
    public IItemService itemService;

    @PostMapping("/create")
    public Item createItem(@RequestBody Item item)
    {
        return itemService.createItem(item);
    }

    @GetMapping("{itemId}")
    public Optional<Item> getItem(@PathVariable String itemId) {
        return itemService.getItem(Integer.parseInt(itemId));
    }
}