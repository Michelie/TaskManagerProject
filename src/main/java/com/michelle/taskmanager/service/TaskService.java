package com.michelle.taskmanager.service;

import com.michelle.taskmanager.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    Task getTaskById(Long taskId);
    Task createTask(Task task, String username);
    Task updateTask(Long taskId, Task task);
    void deleteTask(Long taskId);
    List<Task> getTasksByUsername(String username);

}
