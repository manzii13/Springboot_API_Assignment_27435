package auca.ac.question5_task_api.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import auca.ac.question5_task_api.model.Task;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private  List<Task> tasks = new ArrayList<>();

    public TaskController() {
        tasks.add(new Task(1L, "Assignment", "Finish Spring Boot API",
                "PENDING", "HIGH", LocalDate.now().plusDays(2)));
        tasks.add(new Task(2L, "Shopping", "Buy groceries",
                "COMPLETED", "LOW", LocalDate.now()));
        tasks.add(new Task(3L, "Study", "Read REST concepts",
                "PENDING", "MEDIUM", LocalDate.now().plusDays(5)));
        
    }


    //get all tasks
    @GetMapping
    public List<Task> getAllTasks(){
        return tasks;

    }

    //get task by id
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id){
        return task.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    //creating new task
    @PostMapping
    public Task addTask(@RequestBody Task task) {
        tasks.add(task);
        return task;
}



    //filter by status
    @GetMapping("/status")
    public List<Task> getByStatus(@RequestParam String status){
        return tasks.stream()
                .filter(t -> t.getStatus().equalsIgnoreCase(status))
                .collect(Collectors.toList());
                
    }

    
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                task.setTitle(updatedTask.getTitle());
                task.setDescription(updatedTask.getDescription());
                task.setStatus(updatedTask.getStatus());
                task.setPriority(updatedTask.getPriority());
                task.setDueDate(updatedTask.getDueDate());
                return task;
        }
    }
        return null;
}


    //mark the task as completed
    @PostMapping("/{id}/complete")
    public Task completeTask(@PathVariable Long id){
        for (Task t : tasks) {
            if (t.getId().equals(id)) {
                t.setStatus("COMPLETED");
                return t;
            }
        }
        return null;
    }

    @PatchMapping("/{id}/status")
    public Task updateTaskStatus(
        @PathVariable Long id,
        @RequestParam String status) {

        for (Task task : tasks) {
            if (task.getId().equals(id)) {
            task.setStatus(status);
            return task;
        }
    }
        return null;
}


    
    //delete task by id
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        tasks.removeIf(t -> t.getId().equals(id));
    }
    
}
