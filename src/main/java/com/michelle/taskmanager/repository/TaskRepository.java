package com.michelle.taskmanager.repository;

import com.michelle.taskmanager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findById(Long taskId);
    List<Task> findByDashboardId(Long dashboardId);
    List<Task> findByStatus(String status);

}
