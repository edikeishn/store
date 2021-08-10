package ru.rayyana.store.service;

import ru.rayyana.store.entity.Item;

import java.util.List;

public interface ItemService {
    List<Item> findAllItems();
    Item findItemById(Long id);
    void addNewItem(Item item);
}
