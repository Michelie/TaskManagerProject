package com.michelle.taskmanager.service;

import com.michelle.taskmanager.entity.Person;
import com.michelle.taskmanager.entity.Task;

import java.util.List;
import java.util.Set;

public interface TaskService {
    List<Task> getAllTasks();
    Task getTask(Long id);
    Task saveTask(Task task);
    void deleteTask(Long id);
    Task addPersonToTask(Long personId, Long taskId);

    Set<Person> getPersonsForTask(Long id);


}
