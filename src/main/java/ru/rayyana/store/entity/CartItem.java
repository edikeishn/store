package ru.rayyana.store.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name="item_id", nullable=false)
    private Item item;

    private int quantity;

    @ManyToOne
    @JoinColumn(name="cart_id", nullable=true)
    @JsonIgnore
    private Cart cart;

    public long getItemId() {
        return this.item.getId();
    }
}
