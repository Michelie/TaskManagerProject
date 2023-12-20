package com.michelle.taskmanager.service;

import com.michelle.taskmanager.entity.Dashboard;
import com.michelle.taskmanager.exception.DashboardNotFoundException;
import com.michelle.taskmanager.repository.DashboardRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DashboardServiceImpl implements DashboardService{
    private DashboardRepository dashboardRepository;

    @Override
    public Dashboard saveDashboard(Dashboard dashboard) {
        return dashboardRepository.save(dashboard);
    }

    @Override
    public List<Dashboard> getAllDashboards() {
        return dashboardRepository.findAll();
    }

    @Override
    public Dashboard getDashboardById(Long id) {
        Optional<Dashboard> dashboard = dashboardRepository.findById(id);
        return unwrapDashboard(dashboard, id);
    }

//    @Override
//    public List<Dashboard> getDashboardsByUserId(Long userId) {
//        return dashboardRepository.findByUserId(userId);
//    }


    @Override
    public Dashboard getDashboardByName(String name) {
        return dashboardRepository.findByName(name);
    }

    @Override
    public void deleteDashboardByName(String name) {
        dashboardRepository.deleteByName(name);
    }


    static Dashboard unwrapDashboard(Optional<Dashboard> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new DashboardNotFoundException(id);
    }
}
