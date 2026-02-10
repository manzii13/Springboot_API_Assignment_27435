package auca.ac.question4_ecommerce_api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import auca.ac.question4_ecommerce_api.model.Product;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private List<Product> products = new ArrayList<>();

    public ProductController() {
        products.add(new Product(1L, "Laptop", "Gaming laptop", 1200000.0, "Electronics", 5, "Dell"));
        products.add(new Product(2L, "Phone", "Smart phone", 800000.0, "Electronics", 10, "Samsung"));
        products.add(new Product(3L, "Shoes", "Running shoes", 60000.0, "Fashion", 0, "Nike"));
        products.add(new Product(4L, "Watch", "Smart watch", 150000.0, "Accessories", 8, "Apple"));
        products.add(new Product(5L, "Headphones", "Wireless headphones", 90000.0, "Electronics", 15, "Sony"));
        products.add(new Product(6L, "T-shirt", "Cotton shirt", 25000.0, "Fashion", 20, "Adidas"));
        products.add(new Product(7L, "TV", "4K Television", 2000000.0, "Electronics", 3, "LG"));
        products.add(new Product(8L, "Bag", "Travel bag", 70000.0, "Fashion", 6, "Puma"));
        products.add(new Product(9L, "Tablet", "Android tablet", 500000.0, "Electronics", 4, "Lenovo"));
        products.add(new Product(10L, "Camera", "Digital camera", 1100000.0, "Electronics", 2, "Canon"));
    }

    @GetMapping
public List<Product> getAllProducts(
        @RequestParam(required = false) Integer page,
        @RequestParam(required = false) Integer limit) {

    if (page == null || limit == null) {
        return products;
    }

    int start = page * limit;
    int end = Math.min(start + limit, products.size());

    return products.subList(start, end);
}


    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable Long productId) {
        return products.stream()
                .filter(product -> product.getProductId().equals(productId))
                .findFirst()
                .orElse(null);
}

    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }


    @GetMapping("/brand/{brand}")
    public List<Product> getByBrand(@PathVariable String brand) {
        return products.stream()
                .filter(p -> p.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
    }

    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String query) {
        return products.stream()
                .filter(p -> p.getName().toLowerCase().contains(query.toLowerCase()) ||
                        p.getDescription().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }


    @GetMapping("/price-range")
    public List<Product> getByPriceRange(@RequestParam Double minPrice, @RequestParam Double maxPrice) {
        return products.stream()
                .filter(p -> p.getPrice() >= minPrice && p.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    @GetMapping("/in-stock")
    public List<Product> getInStockProducts() {
        return products.stream()
                .filter(p -> p.getStockQuantity() > 0)
                .collect(Collectors.toList());
    }

    @PutMapping("/{productId}")
    public Product updateProduct(@PathVariable Long productId, @RequestBody Product updated){
        for(Product p: products){
            if(p.getProductId().equals(productId)){
                products.remove(p);
                products.add(updated);
                return updated;

            }
        }
        return null;
    }

    @PatchMapping("/{productId}/stock")
    public Product updateStock(@PathVariable Long productId, @RequestParam int quantity){
        for (Product p: products){
            if(p.getProductId().equals(productId)){
                p.setStockQuantity(quantity);
                return p;
            }
        }
        return null;
    }

    @DeleteMapping("/{productId}")
public void deleteProduct(@PathVariable Long productId){
    products.removeIf(p -> p.getProductId().equals(productId));
}



}
