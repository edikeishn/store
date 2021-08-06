package ru.rayyana.store.controller.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.rayyana.store.entity.Cart;
import ru.rayyana.store.entity.CartItem;
import ru.rayyana.store.entity.Item;
import ru.rayyana.store.service.CartService;
import ru.rayyana.store.service.ItemService;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<CartItem> getAllItemsInCart() {
        List<CartItem> cartItems = cartService.getCart().getCartItems();
        return cartItems;
    }

    @PostMapping
    public List<CartItem> addItemToCart(@RequestBody Item item) {
        Cart cart = cartService.getCart();
        cart.addItemToCart(item);
        cartService.saveCart(cart);
        return getAllItemsInCart();
    }

    @PostMapping("/removeAllItems")
    public void removeAllItemsFromCart(){
        Cart cart = cartService.getCart();
        cart.removeAllItemsFromCart();
        cartService.saveCart(cart);
    }
}
