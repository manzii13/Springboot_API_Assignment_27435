# Spring Boot RESTful API Assignment
### Module 1-3: Introduction to Spring Boot & Building REST Controllers

---

## Project Overview

This repository contains **6 Spring Boot REST API projects**, each built as a separate application. All projects use only the **Spring Web** dependency and implement REST controllers with in-memory data storage (no service or repository layers).

---

## Repository Structure

```
restFull_api_StudentId/
├── question1-library-api/
├── question2-student-api/
├── question3-restaurant-api/
├── question4-ecommerce-api/
├── question5-task-api/
└── bonus-user-profile-api/
```

---

## How to Run Any Application

1. **Prerequisites**: Java JDK 17+ and Maven installed
2. **Navigate** to the project folder (e.g., `cd question1-library-api`)
3. **Run** the application:
   ```bash
   ./mvnw spring-boot:run
   ```
   Or build and run the JAR:
   ```bash
   ./mvnw clean package
   java -jar target/*.jar
   ```
4. **Default port**: `http://localhost:8080`
5. **Test** endpoints using Postman or a browser

---

---

## Question 1: Library Book Management API

**Port:** `8080` | **Base URL:** `/api/books`

### Project Structure
```
question1-library-api/
└── src/main/java/library/api/question1_library_api/
    ├── Question1LibraryApiApplication.java
    ├── controller/
    │   └── BookController.java
    └── model/
        └── Book.java
```

### Model: `Book`
| Field | Type |
|-------|------|
| id | Long |
| title | String |
| author | String |
| isbn | String |
| publishedYear | int |

### Sample Data (pre-loaded)
- *1984* by George Orwell (1949)
- *To Kill a Mockingbird* by Harper Lee (1960)
- *The Great Gatsby* by F. Scott Fitzgerald (1925)

### Endpoints

#### GET /api/books
Returns all books.

**Sample Response (200 OK):**
```json
[
  {
    "id": 1,
    "title": "1984",
    "author": "George Orwell",
    "isbn": "9780451524935",
    "publishedYear": 1949
  },
  {
    "id": 2,
    "title": "To Kill a Mockingbird",
    "author": "Harper Lee",
    "isbn": "9780060935467",
    "publishedYear": 1960
  }
]
```

---

#### GET /api/books/{id}
Returns a specific book by ID.

**Sample Request:** `GET /api/books/1`

**Sample Response (200 OK):**
```json
{
  "id": 1,
  "title": "1984",
  "author": "George Orwell",
  "isbn": "9780451524935",
  "publishedYear": 1949
}
```

**Not Found (404):** Returns empty body with 404 status.

---

#### GET /api/books/search?title={title}
Searches books by title (case-insensitive partial match).

**Sample Request:** `GET /api/books/search?title=great`

**Sample Response (200 OK):**
```json
[
  {
    "id": 3,
    "title": "The Great Gatsby",
    "author": "F. Scott Fitzgerald",
    "isbn": "9780743273565",
    "publishedYear": 1925
  }
]
```

---

#### POST /api/books
Adds a new book.

**Sample Request Body:**
```json
{
  "id": 4,
  "title": "Clean Code",
  "author": "Robert Martin",
  "isbn": "978-0132350884",
  "publishedYear": 2008
}
```

**Sample Response (201 Created):**
```json
{
  "id": 4,
  "title": "Clean Code",
  "author": "Robert Martin",
  "isbn": "978-0132350884",
  "publishedYear": 2008
}
```

---

#### DELETE /api/books/{id}
Deletes a book by ID.

**Sample Request:** `DELETE /api/books/2`

**Sample Response (204 No Content):** Empty body.

---

---

## Question 2: Student Registration API

**Port:** `8080` | **Base URL:** `/api/students`

### Project Structure
```
question2-student-api/
└── src/main/java/auca/ac/question2_student_api/
    ├── Question2StudentApiApplication.java
    ├── controller/
    │   └── StudentController.java
    └── model/
        └── Student.java
```

### Model: `Student`
| Field | Type |
|-------|------|
| studentId | Long |
| firstname | String |
| lastname | String |
| email | String |
| major | String |
| gpa | Double |

### Sample Data (pre-loaded — 6 students)
| ID | Name | Major | GPA |
|----|------|-------|-----|
| 1 | Manzi David | Computer Science | 3.5 |
| 2 | Smith John | Mathematics | 3.8 |
| 3 | Chris Bruce | Physics | 3.2 |
| 4 | Alice Kirezi | Information Technology | 3.9 |
| 5 | Bob Johnson | Business Administration | 3.4 |
| 6 | Eve Davis | Software Engineering | 3.6 |

### Endpoints

#### GET /api/students
Returns all students.

**Sample Response (200 OK):**
```json
[
  { "studentId": 1, "firstname": "Manzi", "lastname": "David", "email": "david@gmail.com", "major": "Computer Science", "gpa": 3.5 },
  { "studentId": 2, "firstname": "Smith", "lastname": "John", "email": "smith@gmail.com", "major": "Mathematics", "gpa": 3.8 }
]
```

---

#### GET /api/students/{studentId}
Returns a student by ID.

**Sample Request:** `GET /api/students/4`

**Sample Response (200 OK):**
```json
{ "studentId": 4, "firstname": "Alice", "lastname": "Kirezi", "email": "alice@gmail.com", "major": "Information Technology", "gpa": 3.9 }
```

---

#### GET /api/students/major/{major}
Returns all students in a given major (case-insensitive).

**Sample Request:** `GET /api/students/major/Computer Science`

**Sample Response (200 OK):**
```json
[
  { "studentId": 1, "firstname": "Manzi", "lastname": "David", "email": "david@gmail.com", "major": "Computer Science", "gpa": 3.5 }
]
```

---

#### GET /api/students/gpa/{gpa}
Returns students with GPA greater than or equal to the given value.

**Sample Request:** `GET /api/students/gpa/3.5`

**Sample Response (200 OK):**
```json
[
  { "studentId": 1, "firstname": "Manzi", "lastname": "David", "major": "Computer Science", "gpa": 3.5 },
  { "studentId": 2, "firstname": "Smith", "lastname": "John", "major": "Mathematics", "gpa": 3.8 },
  { "studentId": 4, "firstname": "Alice", "lastname": "Kirezi", "major": "Information Technology", "gpa": 3.9 },
  { "studentId": 6, "firstname": "Eve", "lastname": "Davis", "major": "Software Engineering", "gpa": 3.6 }
]
```

---

#### POST /api/students
Registers a new student.

**Sample Request Body:**
```json
{
  "studentId": 7,
  "firstname": "Grace",
  "lastname": "Uwase",
  "email": "grace@gmail.com",
  "major": "Computer Science",
  "gpa": 3.7
}
```

**Sample Response (200 OK):** Returns the created student object.

---

#### PUT /api/students/{studentId}
Updates an existing student's information.

**Sample Request:** `PUT /api/students/1`

**Sample Request Body:**
```json
{
  "firstname": "Manzi",
  "lastname": "David",
  "email": "manzi.updated@gmail.com",
  "major": "Computer Science",
  "gpa": 3.9
}
```

**Sample Response (200 OK):** Returns the updated student object.

---

---

## Question 3: Restaurant Menu API

**Port:** `8080` | **Base URL:** `/api/menu`

### Project Structure
```
question3-restaurant-api/
└── src/main/java/auca/ac/question3_restaurant_api/
    ├── Question3RestaurantApiApplication.java
    ├── controller/
    │   └── MenuController.java
    └── model/
        └── MenuItem.java
```

### Model: `MenuItem`
| Field | Type |
|-------|------|
| id | Long |
| name | String |
| description | String |
| price | double |
| category | String |
| available | boolean |

### Sample Data (pre-loaded — 8 items)
| ID | Name | Category | Price (RWF) | Available |
|----|------|----------|-------------|-----------|
| 1 | Burger | Main Course | 5,000 | ✅ |
| 2 | Pizza | Main Course | 10,000 | ✅ |
| 3 | Salad | Appetizer | 7,000 | ✅ |
| 4 | Fries | Appetizer | 5,000 | ✅ |
| 5 | Ice Cream | Dessert | 2,500 | ✅ |
| 6 | Cake | Dessert | 6,000 | ❌ |
| 7 | Soda | Beverage | 2,000 | ✅ |
| 8 | Coffee | Beverage | 3,500 | ✅ |

### Endpoints

#### GET /api/menu
Returns all menu items.

**Sample Response (200 OK):**
```json
[
  { "id": 1, "name": "Burger", "description": "Beef burger", "price": 5000.0, "category": "Main Course", "available": true },
  { "id": 6, "name": "Cake", "description": "Chocolate cake", "price": 6000.0, "category": "Dessert", "available": false }
]
```

---

#### GET /api/menu/{id}
Returns a specific menu item by ID.

**Sample Request:** `GET /api/menu/2`

**Sample Response (200 OK):**
```json
{ "id": 2, "name": "Pizza", "description": "Cheese pizza", "price": 10000.0, "category": "Main Course", "available": true }
```

---

#### GET /api/menu/category/{category}
Returns items by category (case-insensitive).

**Sample Request:** `GET /api/menu/category/Dessert`

**Sample Response (200 OK):**
```json
[
  { "id": 5, "name": "Ice Cream", "description": "Vanilla ice cream", "price": 2500.0, "category": "Dessert", "available": true },
  { "id": 6, "name": "Cake", "description": "Chocolate cake", "price": 6000.0, "category": "Dessert", "available": false }
]
```

---

#### GET /api/menu/available?available={true/false}
Returns items filtered by availability.

**Sample Request:** `GET /api/menu/available?available=true`

**Sample Response (200 OK):** Returns all 7 available items.

**Sample Request:** `GET /api/menu/available?available=false`

**Sample Response (200 OK):**
```json
[
  { "id": 6, "name": "Cake", "description": "Chocolate cake", "price": 6000.0, "category": "Dessert", "available": false }
]
```

---

#### GET /api/menu/search?name={name}
Searches menu items by name (case-insensitive partial match).

**Sample Request:** `GET /api/menu/search?name=coffee`

**Sample Response (200 OK):**
```json
[
  { "id": 8, "name": "Coffee", "description": "Hot coffee", "price": 3500.0, "category": "Beverage", "available": true }
]
```

---

#### POST /api/menu
Adds a new menu item.

**Sample Request Body:**
```json
{
  "id": 9,
  "name": "Juice",
  "description": "Fresh orange juice",
  "price": 3000.0,
  "category": "Beverage",
  "available": true
}
```

**Sample Response (200 OK):** Returns the created menu item.

---

#### POST /api/menu/{id}/availability
Toggles the availability of a menu item.

**Sample Request:** `POST /api/menu/6/availability`

**Sample Response (200 OK):**
```json
{ "id": 6, "name": "Cake", "description": "Chocolate cake", "price": 6000.0, "category": "Dessert", "available": true }
```
> Cake was unavailable — it is now toggled to `available: true`.

---

#### DELETE /api/menu/{id}
Removes a menu item.

**Sample Request:** `DELETE /api/menu/4`

**Sample Response (200 OK):** Empty body.

---

---

## Question 4: E-Commerce Product API

**Port:** `8080` | **Base URL:** `/api/products`

### Project Structure
```
question4-ecommerce-api/
└── src/main/java/auca/ac/question4_ecommerce_api/
    ├── Question4EcommerceApiApplication.java
    ├── controller/
    │   └── ProductController.java
    └── model/
        └── Product.java
```

### Model: `Product`
| Field | Type |
|-------|------|
| productId | Long |
| name | String |
| description | String |
| price | Double |
| category | String |
| stockQuantity | int |
| brand | String |

### Sample Data (pre-loaded — 10 products)
| ID | Name | Category | Price (RWF) | Stock | Brand |
|----|------|----------|-------------|-------|-------|
| 1 | Laptop | Electronics | 1,200,000 | 5 | Dell |
| 2 | Phone | Electronics | 800,000 | 10 | Samsung |
| 3 | Shoes | Fashion | 60,000 | 0 | Nike |
| 4 | Watch | Accessories | 150,000 | 8 | Apple |
| 5 | Headphones | Electronics | 90,000 | 15 | Sony |
| 6 | T-shirt | Fashion | 25,000 | 20 | Adidas |
| 7 | TV | Electronics | 2,000,000 | 3 | LG |
| 8 | Bag | Fashion | 70,000 | 6 | Puma |
| 9 | Tablet | Electronics | 500,000 | 4 | Lenovo |
| 10 | Camera | Electronics | 1,100,000 | 2 | Canon |

### Endpoints

#### GET /api/products
Returns all products. Supports optional pagination.

**Sample Request (all):** `GET /api/products`

**Sample Request (paginated):** `GET /api/products?page=0&limit=3`

**Sample Response (200 OK — paginated, page 0, limit 3):**
```json
[
  { "productId": 1, "name": "Laptop", "price": 1200000.0, "category": "Electronics", "brand": "Dell", "stockQuantity": 5 },
  { "productId": 2, "name": "Phone", "price": 800000.0, "category": "Electronics", "brand": "Samsung", "stockQuantity": 10 },
  { "productId": 3, "name": "Shoes", "price": 60000.0, "category": "Fashion", "brand": "Nike", "stockQuantity": 0 }
]
```

---

#### GET /api/products/{productId}
Returns a product by ID.

**Sample Request:** `GET /api/products/7`

**Sample Response (200 OK):**
```json
{ "productId": 7, "name": "TV", "description": "4K Television", "price": 2000000.0, "category": "Electronics", "stockQuantity": 3, "brand": "LG" }
```

---

#### GET /api/products/category/{category}
Returns all products in a category.

**Sample Request:** `GET /api/products/category/Fashion`

**Sample Response (200 OK):**
```json
[
  { "productId": 3, "name": "Shoes", "brand": "Nike", "price": 60000.0 },
  { "productId": 6, "name": "T-shirt", "brand": "Adidas", "price": 25000.0 },
  { "productId": 8, "name": "Bag", "brand": "Puma", "price": 70000.0 }
]
```

---

#### GET /api/products/brand/{brand}
Returns products by brand.

**Sample Request:** `GET /api/products/brand/Sony`

**Sample Response (200 OK):**
```json
[
  { "productId": 5, "name": "Headphones", "description": "Wireless headphones", "price": 90000.0, "category": "Electronics", "stockQuantity": 15, "brand": "Sony" }
]
```

---

#### GET /api/products/search?query={keyword}
Searches products by keyword in name or description.

**Sample Request:** `GET /api/products/search?query=wireless`

**Sample Response (200 OK):**
```json
[
  { "productId": 5, "name": "Headphones", "description": "Wireless headphones", "price": 90000.0, "brand": "Sony" }
]
```

---

#### GET /api/products/price-range?minPrice={min}&maxPrice={max}
Returns products within a price range.

**Sample Request:** `GET /api/products/price-range?minPrice=50000&maxPrice=200000`

**Sample Response (200 OK):**
```json
[
  { "productId": 3, "name": "Shoes", "price": 60000.0 },
  { "productId": 4, "name": "Watch", "price": 150000.0 },
  { "productId": 5, "name": "Headphones", "price": 90000.0 },
  { "productId": 6, "name": "T-shirt", "price": 25000.0 },
  { "productId": 8, "name": "Bag", "price": 70000.0 }
]
```

---

#### GET /api/products/in-stock
Returns only products with `stockQuantity > 0`.

**Sample Request:** `GET /api/products/in-stock`

**Sample Response (200 OK):** Returns 9 products (excludes Shoes with stock = 0).

---

#### PUT /api/products/{productId}
Replaces a product with updated details.

**Sample Request:** `PUT /api/products/1`

**Sample Request Body:**
```json
{
  "productId": 1,
  "name": "Gaming Laptop",
  "description": "High-performance gaming laptop",
  "price": 1500000.0,
  "category": "Electronics",
  "stockQuantity": 4,
  "brand": "Dell"
}
```

**Sample Response (200 OK):** Returns the updated product.

---

#### PATCH /api/products/{productId}/stock?quantity={quantity}
Updates the stock quantity of a product.

**Sample Request:** `PATCH /api/products/3/stock?quantity=10`

**Sample Response (200 OK):**
```json
{ "productId": 3, "name": "Shoes", "stockQuantity": 10, "brand": "Nike" }
```

---

#### DELETE /api/products/{productId}
Deletes a product.

**Sample Request:** `DELETE /api/products/10`

**Sample Response (200 OK):** Empty body.

---

---

## Question 5: Task Management API

**Port:** `8080` | **Base URL:** `/api/tasks`

### Project Structure
```
question5-task-api/
└── src/main/java/auca/ac/question5_task_api/
    ├── Question5TaskApiApplication.java
    ├── controller/
    │   └── TaskController.java
    └── model/
        └── Task.java
```

### Model: `Task`
| Field | Type |
|-------|------|
| id | Long |
| title | String |
| description | String |
| status | String (`PENDING` / `COMPLETED`) |
| priority | String (`LOW` / `MEDIUM` / `HIGH`) |
| dueDate | LocalDate (`YYYY-MM-DD`) |

### Sample Data (pre-loaded — 3 tasks)
| ID | Title | Status | Priority | Due Date |
|----|-------|--------|----------|----------|
| 1 | Assignment | PENDING | HIGH | Today + 2 days |
| 2 | Shopping | COMPLETED | LOW | Today |
| 3 | Study | PENDING | MEDIUM | Today + 5 days |

### Endpoints

#### GET /api/tasks
Returns all tasks.

**Sample Response (200 OK):**
```json
[
  { "id": 1, "title": "Assignment", "description": "Finish Spring Boot API", "status": "PENDING", "priority": "HIGH", "dueDate": "2026-02-12" },
  { "id": 2, "title": "Shopping", "description": "Buy groceries", "status": "COMPLETED", "priority": "LOW", "dueDate": "2026-02-10" },
  { "id": 3, "title": "Study", "description": "Read REST concepts", "status": "PENDING", "priority": "MEDIUM", "dueDate": "2026-02-15" }
]
```

---

#### GET /api/tasks/{id}
Returns a task by ID.

**Sample Request:** `GET /api/tasks/1`

**Sample Response (200 OK):**
```json
{ "id": 1, "title": "Assignment", "description": "Finish Spring Boot API", "status": "PENDING", "priority": "HIGH", "dueDate": "2026-02-12" }
```

---

#### GET /api/tasks/status?status={status}
Returns tasks filtered by status.

**Sample Request:** `GET /api/tasks/status?status=PENDING`

**Sample Response (200 OK):**
```json
[
  { "id": 1, "title": "Assignment", "status": "PENDING", "priority": "HIGH" },
  { "id": 3, "title": "Study", "status": "PENDING", "priority": "MEDIUM" }
]
```

---

#### POST /api/tasks
Creates a new task.

**Sample Request Body:**
```json
{
  "id": 4,
  "title": "Exercise",
  "description": "Morning run",
  "status": "PENDING",
  "priority": "LOW",
  "dueDate": "2026-02-11"
}
```

**Sample Response (200 OK):** Returns the created task.

---

#### PUT /api/tasks/{id}
Updates all fields of an existing task.

**Sample Request:** `PUT /api/tasks/3`

**Sample Request Body:**
```json
{
  "title": "Study REST APIs",
  "description": "Read chapters 1-5",
  "status": "PENDING",
  "priority": "HIGH",
  "dueDate": "2026-02-14"
}
```

**Sample Response (200 OK):** Returns the updated task.

---

#### POST /api/tasks/{id}/complete
Marks a task as completed.

**Sample Request:** `POST /api/tasks/1/complete`

**Sample Response (200 OK):**
```json
{ "id": 1, "title": "Assignment", "status": "COMPLETED", "priority": "HIGH" }
```

---

#### PATCH /api/tasks/{id}/status?status={status}
Updates only the status of a task.

**Sample Request:** `PATCH /api/tasks/3/status?status=COMPLETED`

**Sample Response (200 OK):**
```json
{ "id": 3, "title": "Study", "status": "COMPLETED", "priority": "MEDIUM" }
```

---

#### DELETE /api/tasks/{id}
Deletes a task by ID.

**Sample Request:** `DELETE /api/tasks/2`

**Sample Response (200 OK):** Empty body.

---

---

## Bonus: User Profile API

**Port:** `8080` | **Base URL:** `/api/users`

### Project Structure
```
bonus-user-profile-api/
└── src/main/java/auca/ac/user_profile_api/
    ├── UserProfileApiApplication.java
    ├── controller/
    │   └── UserProfileController.java
    └── model/
        ├── UserProfile.java
        └── ApiResponse.java
```

### Model: `UserProfile`
| Field | Type |
|-------|------|
| userId | Long |
| username | String |
| email | String |
| fullName | String |
| age | int |
| country | String |
| bio | String |
| active | boolean |

### Response Wrapper: `ApiResponse<T>`
All responses are wrapped in the following structure:
```json
{
  "success": true,
  "message": "Descriptive message here",
  "data": { ... }
}
```

### Sample Data (pre-loaded — 2 users)
| ID | Username | Country | Age | Active |
|----|----------|---------|-----|--------|
| 1 | john_doe | USA | 25 | ✅ |
| 2 | mary99 | UK | 30 | ❌ |

### Endpoints

#### POST /api/users
Creates a new user profile.

**Sample Request Body:**
```json
{
  "userId": 3,
  "username": "alice_rw",
  "email": "alice@gmail.com",
  "fullName": "Alice Uwase",
  "age": 22,
  "country": "Rwanda",
  "bio": "Student at AUCA",
  "active": true
}
```

**Sample Response (201 Created):**
```json
{
  "success": true,
  "message": "User profile created successfully",
  "data": {
    "userId": 3,
    "username": "alice_rw",
    "email": "alice@gmail.com",
    "fullName": "Alice Uwase",
    "age": 22,
    "country": "Rwanda",
    "bio": "Student at AUCA",
    "active": true
  }
}
```

---

#### GET /api/users
Returns all user profiles.

**Sample Response (200 OK):**
```json
{
  "success": true,
  "message": "User profiles retrieved",
  "data": [
    { "userId": 1, "username": "john_doe", "email": "john@gmail.com", "fullName": "John Doe", "age": 25, "country": "USA", "active": true },
    { "userId": 2, "username": "mary99", "email": "mary@gmail.com", "fullName": "Mary Smith", "age": 30, "country": "UK", "active": false }
  ]
}
```

---

#### GET /api/users/{id}
Returns a user by ID.

**Sample Request:** `GET /api/users/1`

**Sample Response (200 OK):**
```json
{
  "success": true,
  "message": "User found",
  "data": { "userId": 1, "username": "john_doe", "fullName": "John Doe", "country": "USA", "active": true }
}
```

**Not Found (404):**
```json
{
  "success": false,
  "message": "User not found",
  "data": null
}
```

---

#### GET /api/users/search?username={username}
Searches users by username (case-insensitive partial match).

**Sample Request:** `GET /api/users/search?username=john`

**Sample Response (200 OK):**
```json
{
  "success": true,
  "message": "Search results",
  "data": [
    { "userId": 1, "username": "john_doe", "fullName": "John Doe" }
  ]
}
```

---

#### GET /api/users/country/{country}
Returns all users from a given country.

**Sample Request:** `GET /api/users/country/UK`

**Sample Response (200 OK):**
```json
{
  "success": true,
  "message": "Users from UK",
  "data": [
    { "userId": 2, "username": "mary99", "fullName": "Mary Smith", "country": "UK" }
  ]
}
```

---

#### GET /api/users/age-range?min={min}&max={max}
Returns users within an age range.

**Sample Request:** `GET /api/users/age-range?min=20&max=28`

**Sample Response (200 OK):**
```json
{
  "success": true,
  "message": "Users in age range",
  "data": [
    { "userId": 1, "username": "john_doe", "age": 25 }
  ]
}
```

---

#### PATCH /api/users/{id}/status?active={true/false}
Activates or deactivates a user profile.

**Sample Request:** `PATCH /api/users/2/status?active=true`

**Sample Response (200 OK):**
```json
{
  "success": true,
  "message": "User status updated",
  "data": { "userId": 2, "username": "mary99", "active": true }
}
```

**Not Found (404):**
```json
{
  "success": false,
  "message": "User not found",
  "data": null
}
```

---

#### DELETE /api/users/{id}
Deletes a user profile.

**Sample Request:** `DELETE /api/users/2`

**Sample Response (200 OK):**
```json
{
  "success": true,
  "message": "User deleted successfully",
  "data": null
}
```

---

---

## HTTP Status Codes Summary

| Code | Meaning | Used In |
|------|---------|---------|
| 200 OK | Successful GET, PUT, PATCH, DELETE | All projects |
| 201 Created | Resource successfully created | POST /api/books, POST /api/users |
| 204 No Content | Successful delete with no body | DELETE /api/books/{id} |
| 404 Not Found | Resource not found | GET /api/books/{id}, GET /api/users/{id} |

---

## Annotations Used

| Annotation | Purpose |
|------------|---------|
| `@RestController` | Marks class as REST controller |
| `@RequestMapping` | Base URL path for controller |
| `@GetMapping` | Maps HTTP GET requests |
| `@PostMapping` | Maps HTTP POST requests |
| `@PutMapping` | Maps HTTP PUT requests |
| `@PatchMapping` | Maps HTTP PATCH requests |
| `@DeleteMapping` | Maps HTTP DELETE requests |
| `@PathVariable` | Binds URL segment to method parameter |
| `@RequestParam` | Binds query parameter to method parameter |
| `@RequestBody` | Binds JSON request body to Java object |

---



- **Branch name:** `restFull_api_StudentId`
- **Deadline:** Next class at 17:59
