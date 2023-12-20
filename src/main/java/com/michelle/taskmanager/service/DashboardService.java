package com.michelle.taskmanager.service;

import com.michelle.taskmanager.entity.Dashboard;

import java.util.List;

public interface DashboardService {

    Dashboard saveDashboard(Dashboard dashboard);  //saving a new dashboard
    List<Dashboard> getAllDashboards();
    Dashboard getDashboardById(Long id);
  //  List<Dashboard> getDashboardsByUserId(Long userId);

    public Dashboard getDashboardByName(String name);
    public void deleteDashboardByName(String name);
}
