package ru.rayyana.store.controller.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.rayyana.store.entity.Item;
import ru.rayyana.store.service.ImageService;
import ru.rayyana.store.service.ItemService;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ImageService imageService;

    @GetMapping
    public List<Item> findAllItems() {
        return itemService.findAllItems();
    }

    @PostMapping("/addnewitem")
    public Item addNewItem(@RequestPart (required = false) Item item, @RequestPart (required = false) MultipartFile file){
        itemService.addNewItem(item);
        System.out.println(file.getOriginalFilename());
        item.setImage(imageService.saveImage(item.getId(),file));
        itemService.addNewItem(item);
        return item;
    }

    @PostMapping("/edititem")
    public Item editItem(@RequestPart (required = false) Item item, @RequestPart (required = false) MultipartFile file){
        Item currentItem = itemService.findItemById(item.getId());
        currentItem.setQuantity(item.getQuantity());
        currentItem.setTitle(item.getTitle());
        currentItem.setDescription(item.getDescription());
        currentItem.setPrice(item.getPrice());
        itemService.addNewItem(currentItem);
        if(file !=null) {
            currentItem.setImage(imageService.saveImage(currentItem.getId(),file));
             itemService.addNewItem(currentItem);}
        return item;
    }

}
