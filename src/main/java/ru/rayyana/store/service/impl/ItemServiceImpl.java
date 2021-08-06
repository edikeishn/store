package ru.rayyana.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rayyana.store.entity.Item;
import ru.rayyana.store.repository.ItemRepository;
import ru.rayyana.store.service.ItemService;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> finAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public void addNewItem(Item item) {
    itemRepository.save(item);
    }
}
