package com.michelle.taskmanager.service;

import com.michelle.taskmanager.entity.Person;
import com.michelle.taskmanager.entity.Task;
import com.michelle.taskmanager.repository.PersonRepository;
import com.michelle.taskmanager.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository;
    private PersonRepository personRepository;

    @Override
    public List<Task> getAllTasks() {
        return (List<Task>)taskRepository.findAll();
    }

    @Override
    public Task getTask(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        return unwrapTask(task, id);
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task addPersonToTask(Long personId, Long taskId) {
        Task task = getTask(taskId);
        Optional<Person> person = personRepository.findById(personId);
        Person unwrappedPerson = PersonServiceImpl.unwrapPerson(person,personId);
        task.getPersons().add(unwrappedPerson);
        return taskRepository.save(task);
    }

    @Override
    public Set<Person> getPersonsForTask(Long id) {
        Task task = getTask(id);
        return task.getPersons();
    }

    static Task unwrapTask(Optional<Task> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new TaskNotFoundException(id);
    }
}
