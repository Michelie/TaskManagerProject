package com.michelle.taskmanager.service;

import com.michelle.taskmanager.entity.Person;
import com.michelle.taskmanager.entity.Task;

import java.util.List;
import java.util.Set;

public interface PersonService {

    Person getPerson(Long id);
    Person savePerson(Person person);
    void deletePerson(Long id);
    List<Person> getPersons();
    Set<Task> getCurrentTasks(Long id);
}
