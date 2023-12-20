package com.michelle.taskmanager.repository;

import com.michelle.taskmanager.entity.Task;
import com.michelle.taskmanager.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(TaskStatus status);
    List<Task> findByDashboardId(Long dashboardId);

}
