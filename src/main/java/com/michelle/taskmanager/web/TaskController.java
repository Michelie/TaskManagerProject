package com.michelle.taskmanager.web;

import com.michelle.taskmanager.entity.Task;
import com.michelle.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/task")
public class TaskController {

    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> createTask(@Valid @RequestBody Task task) {
        return new ResponseEntity<>(taskService.saveTask(task), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id) {
        return new ResponseEntity<>(taskService.getTaskById(id), HttpStatus.OK);
    }

//    @GetMapping("/status/{status}")
//    public ResponseEntity<List<Task>> getTasksByStatus(@PathVariable TaskStatus status) {
//        return new ResponseEntity<>(taskService.getTasksByStatus(status), HttpStatus.OK);
//    }
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Task>> getTasksByStatus(@PathVariable String status) {
    return new ResponseEntity<>(taskService.getTasksByStatus(status), HttpStatus.OK);
}

    @GetMapping("/dashboard/{dashboardId}")
    public ResponseEntity<List<Task>> getTasksByDashboardId(@PathVariable Long dashboardId) {
        return new ResponseEntity<>(taskService.getTasksByDashboardId(dashboardId), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Task>> getAllTasks() {
        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{taskId}/dashboard/{dashboardId}")
    public ResponseEntity<Task> updateTaskDashboard(@PathVariable Long taskId, @PathVariable Long dashboardId) {
        Task updatedTask = taskService.updateTaskDashboard(taskId, dashboardId);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    @PutMapping("/{taskId}/status/{newStatus}")
    public ResponseEntity<Task> updateTaskStatus( @PathVariable Long taskId, @Valid @PathVariable String newStatus) {
        Task updatedTask = taskService.updateTaskStatus(taskId, newStatus);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

}
