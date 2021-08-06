package ru.rayyana.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rayyana.store.entity.Cart;
import ru.rayyana.store.repository.CartRepository;
import ru.rayyana.store.service.CartService;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;


    @Override
    public Cart getCart() {
        return cartRepository.findAll().get(0);
      }

    @Override
    public void saveCart(Cart cart) {
        cartRepository.save(cart);
    }
}
