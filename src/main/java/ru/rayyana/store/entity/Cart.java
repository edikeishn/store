package ru.rayyana.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "cart", orphanRemoval = true)
    private List<CartItem> cartItems = new LinkedList<>();

    public void addItemToCart(Item item) {
        AtomicBoolean cartItemExists = new AtomicBoolean(false);
        cartItems.forEach(cartItem -> {
            if (cartItem.getItem().getId()== item.getId()) {
                cartItem.setQuantity(cartItem.getQuantity()+1);
                cartItemExists.set(true);
            }
        });
        if (!cartItemExists.get()) {
            CartItem newCartItem = new CartItem();
            newCartItem.setQuantity(1);
            newCartItem.setItem(item);
            this.cartItems.add(newCartItem);
            newCartItem.setCart(this);
        }
    }

    public void removeItemFromCart(Item item) {
        List<CartItem> currentCartItems = new LinkedList<CartItem>(cartItems);
        currentCartItems.forEach(cartItem -> {
            if (cartItem.getItem().getId()== item.getId() && cartItem.getQuantity()>1) {
                cartItem.setQuantity(cartItem.getQuantity()-1);
            }
            else if (cartItem.getItem().getId()== item.getId() && cartItem.getQuantity()==1){
                cartItem.setCart(null);
                this.cartItems.remove(cartItem);


            }
        });

    }

    public void removeAllItemsFromCart() {
        this.cartItems.clear();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                '}';
    }
}
