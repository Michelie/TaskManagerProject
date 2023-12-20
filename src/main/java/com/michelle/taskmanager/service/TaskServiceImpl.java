package com.michelle.taskmanager.service;

import com.michelle.taskmanager.entity.Dashboard;
import com.michelle.taskmanager.entity.Task;
import com.michelle.taskmanager.exception.TaskNotFoundException;
import com.michelle.taskmanager.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository;
    DashboardService dashboardService;
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

//    @Override
//    public List<Task> getTasksByStatus(TaskStatus status) {
//        return taskRepository.findByStatus(status);
//    }


    @Override
    public List<Task> getTasksByStatus(String status) {
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

    @Override
    @Transactional
    public Task updateTaskDashboard(Long taskId, Long dashboardId) {
        Task task = getTaskById(taskId);
        Dashboard dashboard = dashboardService.getDashboardById(dashboardId);

        task.setDashboard(dashboard);
        return taskRepository.save(task);
    }

    @Override
    @Transactional
    public Task updateTaskStatus(Long taskId, String newStatus) {
        Task task = getTaskById(taskId);

        task.setStatus(newStatus);
        return taskRepository.save(task);
    }

    static Task unwrapTask(Optional<Task> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new TaskNotFoundException(id);
    }

}
