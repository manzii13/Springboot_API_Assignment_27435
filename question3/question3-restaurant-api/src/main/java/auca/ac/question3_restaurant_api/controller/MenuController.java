package auca.ac.question3_restaurant_api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import auca.ac.question3_restaurant_api.model.MenuItem;


@RestController
@RequestMapping("/api/menu")
public class MenuController {
    private List<MenuItem>menu = new ArrayList<>();
    

    public MenuController() {
        menu.add(new MenuItem(1L, "Burger", "Beef burger", 5000.0, "Main Course", true));
        menu.add(new MenuItem(2L, "Pizza", "Cheese pizza", 10000.0, "Main Course", true));
        menu.add(new MenuItem(3L, "Salad", "Fresh salad", 7000.0, "Appetizer", true));
        menu.add(new MenuItem(4L, "Fries", "French fries", 5000.0, "Appetizer", true));
        menu.add(new MenuItem(5L, "Ice Cream", "Vanilla ice cream", 2500.0, "Dessert", true));
        menu.add(new MenuItem(6L, "Cake", "Chocolate cake", 6000.0, "Dessert", false));
        menu.add(new MenuItem(7L, "Soda", "Cold drink", 2000.0, "Beverage", true));
        menu.add(new MenuItem(8L, "Coffee", "Hot coffee", 3500.0, "Beverage", true));
    }
    
    //get all menu items
    @GetMapping
    public List<MenuItem> getMenuItems() {
        return menu;
    }

    //get menu item by id
    @GetMapping("/{id}")
    public MenuItem getMenuItemById(@PathVariable Long id) {
        return menu.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    //get items by category
    @GetMapping("/category/{category}")
    public List<MenuItem> getByCategory(@PathVariable String category) {
        return menu.stream()
                .filter(item -> item.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    //search by name
    @GetMapping("/search")
    public List<MenuItem> searchByName(@RequestParam String name) {
        return menu.stream()
                .filter(item -> item.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    //post new menu item
    @PostMapping
    public MenuItem addMenuItem(@RequestBody MenuItem item) {
        menu.add(item);
        return item;
    }


    //toggle avalability
    @PostMapping("/{id}/availability")
    public MenuItem toggleAvailability(@PathVariable Long id) {
        for (MenuItem item : menu) {
            if (item.getId().equals(id)) {
                item.setAvailable(!item.isAvailable());
                return item;
            }
        }        return null;
    }
    
    // get available menu items
    @GetMapping("/available")
    public List<MenuItem> getAvailableItems(@RequestParam boolean available) {
        return menu.stream()
                .filter(item -> item.isAvailable() == available)
                .collect(Collectors.toList());
}


    //delete menu item
    @DeleteMapping("/{id}")
    public void deleteMenuItem(@PathVariable Long id) {
        menu.removeIf(item -> item.getId().equals(id));
    }
    
    

    
}
