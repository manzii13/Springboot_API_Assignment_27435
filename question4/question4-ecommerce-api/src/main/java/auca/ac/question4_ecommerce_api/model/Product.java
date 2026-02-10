package auca.ac.question4_ecommerce_api.model;

public class Product {
    private Long productId;
    private String name;
    private String description;
    private Double price;
    private String category;
    private int stockQuantity;
    private String brand;
    public Product() {
    }

    public Product(Long productId, String name, String description, Double price, String category, int stockQuantity, String brand) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.stockQuantity = stockQuantity;
        this.brand = brand;
    }

    public Long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public String getBrand() {
        return brand;
    }
    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }


}
