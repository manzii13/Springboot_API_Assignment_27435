---------- Task Management API-----------------

Project Name: question5-task-api

Description:
This project is a Spring Boot RESTful API for managing tasks (to-do list).
It allows users to create, view, update, complete, filter, and delete tasks.

Packages:

- auca.ac.question5_task_api.controller
- auca.ac.question5_task_api.model

How to Run:

1. Open project in IDE (IntelliJ or VS Code)
2. Run the main Spring Boot application
3. Access API using browser or Postman at http://localhost:8080

Endpoints:

1. GET /api/tasks
   Get all tasks.

2. GET /api/tasks/{id}
   Get task by ID.

3. POST /api/tasks
   Create new task.
   Sample JSON:
   {
   "id": 4,
   "title": "Workout",
   "description": "Go to gym",
   "status": "PENDING",
   "priority": "HIGH",
   "dueDate": "2026-02-15"
   }

4. GET /api/tasks/status?status=PENDING
   Filter tasks by status.

5. PUT /api/tasks/{id}
   Update full task.

6. POST /api/tasks/{id}/complete
   Mark task as completed.

7. PATCH /api/tasks/{id}/status?status=COMPLETED
   Update only task status.

8. DELETE /api/tasks/{id}
   Delete task.

Testing:
Tested using Postman.
Includes sample tasks.
All responses are in JSON format.
