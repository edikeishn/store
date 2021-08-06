package ru.rayyana.store.service;

import ru.rayyana.store.entity.Item;

import java.util.List;

public interface ItemService {
    List<Item> finAllItems();
    void addNewItem(Item item);
}
