--------- E-Commerce Product API------------------

Project Name: question4-ecommerce-api

Description:
This project is a Spring Boot RESTful API for managing an e-commerce product catalog.
It allows users to view products, search, filter, update stock, and delete products.

Packages:

- auca.ac.question4_ecommerce_api.controller
- auca.ac.question4_ecommerce_api.model

How to Run:

1. Open project in IDE (IntelliJ or VS Code)
2. Run the main Spring Boot application
3. Access API using browser or Postman at http://localhost:8080

Endpoints:

1. GET /api/products
   Get all products (with optional pagination).
   Example:
   /api/products?page=0&limit=5

2. GET /api/products/{productId}
   Get product by ID.

3. GET /api/products/category/{category}
   Get products by category.

4. GET /api/products/brand/{brand}
   Get products by brand.

5. GET /api/products/search?query={keyword}
   Search products by name or description.

6. GET /api/products/price-range?minPrice=50000&maxPrice=500000
   Get products within price range.

7. GET /api/products/in-stock
   Get only products in stock.

8. PUT /api/products/{productId}
   Update full product.
   Sample JSON:
   {
   "productId": 11,
   "name": "Speaker",
   "description": "Bluetooth speaker",
   "price": 45000,
   "category": "Electronics",
   "stockQuantity": 12,
   "brand": "JBL"
   }

9. PATCH /api/products/{productId}/stock?quantity=20
   Update only stock quantity.

10. DELETE /api/products/{productId}
    Delete product.

Testing:
Tested using Postman.
All endpoints return JSON.
Includes 10 sample products.
