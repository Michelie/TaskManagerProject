package com.michelle.taskmanager.web;

import com.michelle.taskmanager.entity.Task;
import com.michelle.taskmanager.entity.TaskStatus;
import com.michelle.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("/task")
public class TaskController {

    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return new ResponseEntity<>(taskService.saveTask(task), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id) {
        return new ResponseEntity<>(taskService.getTaskById(id), HttpStatus.OK);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Task>> getTasksByStatus(@PathVariable TaskStatus status) {
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

}
