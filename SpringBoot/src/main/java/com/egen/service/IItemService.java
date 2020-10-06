package com.egen.service;

import com.egen.entity.Item;

import java.util.Optional;

public interface IItemService {

    public Item createItem(Item item);

    public Optional<Item> getItem(int itemId);
}
