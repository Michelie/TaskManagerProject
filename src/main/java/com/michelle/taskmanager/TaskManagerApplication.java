package com.michelle.taskmanager;

import com.michelle.taskmanager.entity.Dashboard;
import com.michelle.taskmanager.repository.TaskRepository;
import com.michelle.taskmanager.service.DashboardService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication @AllArgsConstructor
public class TaskManagerApplication implements CommandLineRunner {

	TaskRepository taskRepository;
	DashboardService dashboardService;
	public static void main(String[] args) {
		SpringApplication.run(TaskManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Dashboard dashboard = new Dashboard();
		dashboard.setName("Default Dashboard");
		dashboard.setDescription("Default description");

		// Save the dashboard
		dashboard = dashboardService.saveDashboard(dashboard);
//		Task[] tasks = new Task[]{
//				new Task("Task 1", "description 1", TaskStatus.DONE, dashboard),
//				new Task("Task 2", "description 2", TaskStatus.IN_PROGRESS, dashboard),
//				new Task("Task 3", "description 3", TaskStatus.DONE, dashboard),
//				new Task("Task 4", "description 4", TaskStatus.TODO, dashboard)
//		};
//
//		for (int i = 0; i < tasks.length; i++) {
//			taskRepository.save(tasks[i]);
//		}



	}
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}


}
