package com.michelle.taskmanager.repository;

import com.michelle.taskmanager.entity.Dashboard;
import com.michelle.taskmanager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DashboardRepository extends JpaRepository<Dashboard, Long> {
    //List<Dashboard> findByUserId(Long userId);
    Dashboard findByName(String name);
    void deleteByName(String name);
    boolean existsByName(String name);

}
