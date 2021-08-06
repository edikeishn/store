package ru.rayyana.store.service;

import ru.rayyana.store.entity.Cart;
import ru.rayyana.store.entity.Item;

public interface CartService {
    Cart getCart();
    void saveCart(Cart cart);
}
