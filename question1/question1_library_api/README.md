--------- Library Book Management API – README------------------
This document explains the implementation of Question 1 of the Spring Boot RESTful API practical assignment. It describes the project structure, the implemented endpoints, expected behaviors, HTTP status codes used, and where screenshots for testing evidence should be placed.
Project Overview
The Library Book Management API is a simple RESTful API built using Spring Boot and Spring Web. It allows basic management of books including listing, searching, adding, and deleting books. The application uses an in-memory list (ArrayList) to store data, as required by the assignment.
Project Structure
The project is organized into two main packages:

1. controller – contains the REST controller class (BookController)
2. model – contains the Book model class

Package naming follows the assignment requirement:
library.api.question1_library_api
Book Model Explanation
The Book class represents a library book entity. It contains the following attributes:

- id (Long): Unique identifier for the book
- title (String): Title of the book
- author (String): Author name
- isbn (String): International Standard Book Number
- publishedYear (int): Year the book was published

The class includes a no-argument constructor, a parameterized constructor, and getter and setter methods to allow proper JSON serialization and deserialization.
BookController Explanation
The BookController class is annotated with @RestController and @RequestMapping('/api/books'). It handles all HTTP requests related to book management. An ArrayList is used to store sample book data initialized in the controller constructor.
Implemented Endpoints

1. GET /api/books
   Returns a list of all available books.
   HTTP Status: 200 OK

2. GET /api/books/{id}
   Returns a specific book based on its ID.
   If the book is found: 200 OK
   If the book is not found: 404 Not Found

3. GET /api/books/search?title={title}
   Searches for books whose titles contain the given keyword (case-insensitive).
   HTTP Status: 200 OK

4. POST /api/books
   Adds a new book to the list.
   Accepts a Book object in JSON format in the request body.
   HTTP Status: 201 Created

5. DELETE /api/books/{id}
   Deletes a book by its ID.
   HTTP Status: 204 No Content
   HTTP Status Codes Used

- 200 OK: Successful GET requests
- 201 Created: Successful POST request when adding a new book
- 204 No Content: Successful DELETE request
- 404 Not Found: When a requested book ID does not exist
  Testing and Screenshots
  All endpoints were tested using Postman or a web browser.

Screenshots showing successful API calls should be placed in a folder named:
screenshots/

Include screenshots for the following:

- GET all books
- GET book by ID
- Search book by title
- Add a new book (POST)
- Delete a book (DELETE)
  How to Run the Application

1. Open the project in an IDE such as IntelliJ IDEA or Eclipse.
2. Ensure the correct JDK version is configured.
3. Run the Spring Boot application.
4. Access the API endpoints using Postman or a browser at:
   http://localhost:8080/api/books
