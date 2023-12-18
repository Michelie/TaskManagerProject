package com.michelle.taskmanager.service;

import com.michelle.taskmanager.entity.Person;
import com.michelle.taskmanager.entity.Task;
import com.michelle.taskmanager.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class PersonServiceImpl implements PersonService {

     PersonRepository personRepository;

    @Override
    public Person getPerson(Long id) {
        Optional<Person> person = personRepository.findById(id);
        return unwrapPerson(person,id);
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public List<Person> getPersons() {
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public Set<Task> getCurrentTasks(Long id) {
         Person person = getPerson(id);
        return person.getTasks();
    }

    static Person unwrapPerson(Optional<Person> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new EntityNotFoundException(id, Person.class);
    }

}
