package ru.rayyana.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rayyana.store.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
