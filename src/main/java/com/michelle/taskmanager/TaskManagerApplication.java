package com.michelle.taskmanager;

import com.michelle.taskmanager.entity.Task;
import com.michelle.taskmanager.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication @AllArgsConstructor
public class TaskManagerApplication implements CommandLineRunner {

	TaskRepository taskRepository;
	UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(TaskManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Task[] tasks = new Task[] {
				new Task("Task1", "Description 1", LocalDate.now(), false),
				new Task("Task2", "Description 2", LocalDate.now(), false),
				new Task("Task3", "Description 3", LocalDate.now(), false)
		};

		for (int i = 0; i < tasks.length; i++) {
			taskRepository.save(tasks[i]);
		}

	}

}
