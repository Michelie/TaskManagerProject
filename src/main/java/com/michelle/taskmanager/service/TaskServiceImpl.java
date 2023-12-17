package com.michelle.taskmanager.service;

import com.michelle.taskmanager.entity.Task;
import com.michelle.taskmanager.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TaskServiceImpl implements TaskService{
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId)
                .orElseThrow(() -> new EntityNotFoundException("Task not found with id: " + taskId));
    }

    @Override
    public Task createTask(Task task) {
        // Add any business logic or validation if needed
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long taskId, Task updatedTask) {
        Task existingTask = getTaskById(taskId);

        // Update existingTask with the fields from updatedTask
        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setDueDate(updatedTask.getDueDate());
        existingTask.setCompleted(updatedTask.isCompleted());

        // Save the updated task
        return taskRepository.save(existingTask);
    }

    @Override
    public void deleteTask(Long taskId) {
        // Check if the task exists before deleting
        getTaskById(taskId);

        taskRepository.deleteById(taskId);
    }
}
