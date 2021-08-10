package ru.rayyana.store.controller.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.rayyana.store.entity.Cart;
import ru.rayyana.store.entity.CartItem;
import ru.rayyana.store.entity.Item;
import ru.rayyana.store.service.CartService;
import ru.rayyana.store.service.ItemService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        cartItems.sort(Comparator.comparing(CartItem::getItemId));
        return cartItems;
    }

    @PostMapping("/add")
    public List<CartItem> addItemToCart(@RequestBody Item item) {
        Item currentItem = itemService.findItemById(item.getId());
        if (currentItem.getQuantity()<1) return getAllItemsInCart();
        Cart cart = cartService.getCart();
        cart.addItemToCart(item);
        currentItem.quantityMinusOne();
        cartService.saveCart(cart);
        itemService.addNewItem(currentItem);
        return getAllItemsInCart();
    }

    @PostMapping("/remove")
    public List<CartItem> deleteItemFromCart(@RequestBody Item item) {
        Item currentItem = itemService.findItemById(item.getId());
        Cart cart = cartService.getCart();
        cart.removeItemFromCart(item);
        currentItem.quantityPlusOne();
        itemService.addNewItem(currentItem);
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
