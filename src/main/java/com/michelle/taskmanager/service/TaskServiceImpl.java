package com.michelle.taskmanager.service;

import com.michelle.taskmanager.entity.Dashboard;
import com.michelle.taskmanager.entity.Task;
import com.michelle.taskmanager.entity.TaskStatus;
import com.michelle.taskmanager.exception.TaskNotFoundException;
import com.michelle.taskmanager.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository;
    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        return unwrapTask(task, id);
    }

    @Override
    public List<Task> getTasksByStatus(TaskStatus status) {
        return taskRepository.findByStatus(status);
    }

    @Override
    public List<Task> getTasksByDashboardId(Long dashboardId) {
        return taskRepository.findByDashboardId(dashboardId);
    }

    @Override
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    static Task unwrapTask(Optional<Task> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new TaskNotFoundException(id);
    }

}
