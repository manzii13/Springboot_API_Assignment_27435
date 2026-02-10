----Student Registration API – README--------------
This document explains the implementation of Question 2 of the Spring Boot RESTful API practical assignment. It describes the project purpose, structure, implemented endpoints, HTTP behaviors, and testing evidence requirements.
Project Overview
The Student Registration API is a RESTful web service developed using Spring Boot and Spring Web. The API manages student registration and retrieval of student information such as major and GPA. All data is stored in-memory using a List, as required by the assignment instructions.
Project Structure
The project is organized into the following main packages:

1. controller – contains StudentController which handles HTTP requests
2. model – contains the Student class representing the student entity

Base package name:
auca.ac.question2_student_api
Student Model Explanation
The Student class represents a student entity in the system. It contains the following attributes:

- studentId (Long): Unique identifier for the student
- firstname (String): Student first name
- lastname (String): Student last name
- email (String): Student email address
- major (String): Field of study
- gpa (Double): Grade Point Average

The class includes a parameterized constructor and standard getter and setter methods to support JSON request and response mapping.
StudentController Explanation
The StudentController class is annotated with @RestController and mapped to '/api/students'. It initializes a list of sample students with different majors and GPAs in the constructor. This controller provides endpoints for retrieving, filtering, adding, and updating student records.
Implemented Endpoints

1. GET /api/students
   Returns a list of all registered students.
   HTTP Status: 200 OK

2. GET /api/students/{studentId}
   Returns a specific student by ID.
   If found: 200 OK
   If not found: null response

3. GET /api/students/major/{major}
   Returns all students enrolled in a specific major (case-insensitive).
   HTTP Status: 200 OK

4. GET /api/students/gpa/{gpa}
   Returns students with GPA greater than or equal to the specified value.
   HTTP Status: 200 OK

5. POST /api/students
   Registers a new student using JSON request body.
   HTTP Status: 201 Created (logical behavior)

6. PUT /api/students/{studentId}
   Updates an existing student’s information.
   HTTP Status: 200 OK
   HTTP Status Codes Used

- 200 OK: Successful retrieval and update operations
- 201 Created: Successful student creation (POST)
- null response: Returned when a student ID is not found (could be improved to 404 Not Found)
  Testing and Screenshots
  All API endpoints were tested using Postman.

Screenshots proving successful API calls should be placed in a folder named:
screenshots/

Include screenshots for:

- Get all students
- Get student by ID
- Filter students by major
- Filter students by GPA
- Add a new student
- Update student details
  How to Run the Application

1. Open the project in an IDE such as IntelliJ IDEA or Eclipse.
2. Ensure the correct JDK is configured.
3. Run the Spring Boot application.
4. Test endpoints using Postman at:
   http://localhost:8080/api/students
