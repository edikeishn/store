package ru.rayyana.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rayyana.store.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
