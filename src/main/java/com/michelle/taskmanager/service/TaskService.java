package com.michelle.taskmanager.service;

import com.michelle.taskmanager.entity.Task;

import java.util.List;

public interface TaskService {
    Task saveTask(Task task);
    List<Task> getAllTasks();
    Task getTaskById(Long id);
//    List<Task> getTasksByStatus(TaskStatus status);
     List<Task> getTasksByStatus(String status);
    List<Task> getTasksByDashboardId(Long dashboardId);
    void deleteTask(Long taskId);

    Task updateTaskDashboard(Long taskId, Long dashboardId);
    Task updateTaskStatus(Long taskId, String newStatus);
}


