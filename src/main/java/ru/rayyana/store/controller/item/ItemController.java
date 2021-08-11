package ru.rayyana.store.controller.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.rayyana.store.entity.Item;
import ru.rayyana.store.service.ItemService;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<Item> findAllItems() {
        return itemService.findAllItems();
    }

    @PostMapping("/addnewitem")
    public Item addNewItem(@RequestPart (required = false) Item item, @RequestPart (required = false) MultipartFile file){
        return item;
    }

}
