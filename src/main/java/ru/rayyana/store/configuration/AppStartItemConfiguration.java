package ru.rayyana.store.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.rayyana.store.entity.Item;
import ru.rayyana.store.service.impl.ItemServiceImpl;

import javax.annotation.PostConstruct;

@Component
public class AppStartItemConfiguration {

    @Autowired
    private ItemServiceImpl itemService;

    @PostConstruct
    public void addStartItems() {
        itemService.addNewItem(new Item(0,"Товар 1","/assets/items/1.jpg","Товар 1",1.00,5));
        itemService.addNewItem(new Item(0,"Товар 2","/assets/items/2.jpg","Товар 2",2.00,5));
        itemService.addNewItem(new Item(0,"Товар 3","/assets/items/3.jpg","Товар 3",3.00,5));
        itemService.addNewItem(new Item(0,"Товар 4","/assets/items/4.jpg","Товар 4",4.00,5));
        itemService.addNewItem(new Item(0,"Товар 5","/assets/items/5.jpg","Товар 5",5.00,5));
        itemService.addNewItem(new Item(0,"Товар 6","/assets/items/6.jpg","Товар 6",6.00,5));
        itemService.addNewItem(new Item(0,"Товар 7","/assets/items/7.jpg","Товар 7",7.00,5));
        itemService.addNewItem(new Item(0,"Товар 8","/assets/items/8.jpg","Товар 8",8.00,5));
        itemService.addNewItem(new Item(0,"Товар 9","/assets/items/9.jpg","Товар 9",9.00,5));
        itemService.addNewItem(new Item(0,"Товар 10","/assets/items/10.jpg","Товар 10",10.00,5));
    }

}
