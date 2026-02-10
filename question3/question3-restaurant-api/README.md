------------ Restaurant Menu API-----------

Project Name: question3-restaurant-api

Description:
This project is a Spring Boot RESTful API for managing a restaurant menu.
It allows users to view, search, add, update availability, and delete menu items.

Packages:

- auca.ac.question3_restaurant_api.controller
- auca.ac.question3_restaurant_api.model

How to Run:

1. Open project in IDE (IntelliJ or VS Code)
2. Run the main Spring Boot application
3. Access API using browser or Postman at http://localhost:8080

Endpoints:

1. GET /api/menu
   Returns all menu items.

2. GET /api/menu/{id}
   Returns menu item by ID.

3. GET /api/menu/category/{category}
   Returns items by category.

4. GET /api/menu/search?name={name}
   Search items by name.

5. GET /api/menu/available?available=true
   Returns available items.

6. POST /api/menu
   Adds new menu item.
   Sample JSON:
   {
   "id": 9,
   "name": "Tea",
   "description": "Hot tea",
   "price": 1500,
   "category": "Beverage",
   "available": true
   }

7. POST /api/menu/{id}/availability
   Toggles availability.

8. DELETE /api/menu/{id}
   Deletes menu item.

Testing:
Tested using Postman.
All endpoints return JSON responses.
