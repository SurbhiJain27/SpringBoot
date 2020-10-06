package com.egen.service.impl;

import com.egen.entity.Item;
import com.egen.repository.ItemRepository;
import com.egen.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemServiceImpl implements IItemService {

    @Autowired
    public ItemRepository itemRepository;

    public Item createItem(Item item)
    {
        Item savedItem = itemRepository.save(item);
        return savedItem;
    }

    public Optional<Item> getItem(int itemId){
        Optional<Item> getItem = itemRepository.findById(itemId);
        return getItem;
    }

}
