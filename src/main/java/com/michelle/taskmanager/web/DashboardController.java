package com.michelle.taskmanager.web;

import com.michelle.taskmanager.entity.Dashboard;
import com.michelle.taskmanager.service.DashboardService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/dashboards")
public class DashboardController {
    DashboardService dashboardService;

    @PostMapping
    public ResponseEntity<Dashboard> createDashboard(@RequestBody Dashboard dashboard) {
        return new ResponseEntity<>(dashboardService.saveDashboard(dashboard), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dashboard> getDashboard(@PathVariable Long id) {
        return new ResponseEntity<>(dashboardService.getDashboardById(id),HttpStatus.OK);
    }

//    @GetMapping("/user/{userId}")
//    public ResponseEntity<List<Dashboard>> getDashboardsByUser(@PathVariable Long userId) {
//        return new ResponseEntity<>(dashboardService.getDashboardsByUserId(userId),HttpStatus.OK);
//    }

    @GetMapping("/all")
    public ResponseEntity<List<Dashboard>> getAllDashboards() {
        return new ResponseEntity<>(dashboardService.getAllDashboards(), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Dashboard> getDashboardByName(@PathVariable String name) {
        return new ResponseEntity<>(dashboardService.getDashboardByName(name), HttpStatus.OK);
    }

    @DeleteMapping("/name/{name}")
    public ResponseEntity<Dashboard> deleteDashboardByName(@PathVariable String name) {
        dashboardService.deleteDashboardByName(name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

