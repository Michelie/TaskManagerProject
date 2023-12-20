package com.michelle.taskmanager.service;

import com.michelle.taskmanager.entity.Task;
import com.michelle.taskmanager.entity.TaskStatus;

import java.util.List;
import java.util.Set;

public interface TaskService {
    Task saveTask(Task task);
    List<Task> getAllTasks();
    Task getTaskById(Long id);
    List<Task> getTasksByStatus(TaskStatus status);
    List<Task> getTasksByDashboardId(Long dashboardId);
    void deleteTask(Long taskId);



}
