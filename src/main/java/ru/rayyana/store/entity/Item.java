package ru.rayyana.store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;

    private String title;
    private String image;
    private String description;
    private double price;
    private double quantity;

    @ManyToOne
    @JoinColumn(name="cart_id", nullable=false)
    private Cart cart;

}
