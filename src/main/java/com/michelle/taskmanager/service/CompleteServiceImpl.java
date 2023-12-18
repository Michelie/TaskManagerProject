package com.michelle.taskmanager.service;

import com.michelle.taskmanager.entity.Complete;
import com.michelle.taskmanager.entity.Person;
import com.michelle.taskmanager.entity.Task;
import com.michelle.taskmanager.repository.CompleteRepository;
import com.michelle.taskmanager.repository.PersonRepository;
import com.michelle.taskmanager.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CompleteServiceImpl implements CompleteService {

    CompleteRepository completeRepository;
    PersonRepository personRepository;
    TaskRepository taskRepository;

    @Override
    public Complete getCompletion(Long personId, Long taskId) {
        Optional<Complete> completion = completeRepository.findByPersonIdAndTaskId(personId, taskId);
        return unwrapCompletion(completion,personId,taskId);
    }

    @Override
    public Complete saveCompletion(Complete complete, Long personId, Long taskId) {
        Person person = PersonServiceImpl.unwrapPerson(personRepository.findById(personId), personId);
        Task task = TaskServiceImpl.unwrapTask(taskRepository.findById(taskId), taskId);
        if (!person.getTasks().contains(task)) throw new StudentNotEnrolledException(studentId, courseId);
        complete.setPerson(person);
        complete.setTask(task);
        return completeRepository.save(complete);
    }

    @Override
    public Complete updateCompletion(String level, Long personId, Long taskId) {
        Optional<Complete> completion = completeRepository.findByPersonIdAndTaskId(personId, taskId);
        Complete unwrappedComp = unwrapCompletion(completion, personId, taskId);
        unwrappedComp.setLevel(level);
        return completeRepository.save(unwrappedComp);
    }

    @Override
    public void deleteCompletion(Long personId, Long taskId) {
        completeRepository.deleteByPersonIdAndTaskId(personId, taskId);

    }

    @Override
    public List<Complete> getPersonCompletion(Long personId) {
        return completeRepository.findByPersonId(personId);
    }

    @Override
    public List<Complete> getTaskCompletion(Long taskId) {
        return completeRepository.findByTaskId(taskId);
    }

    @Override
    public List<Complete> getAllCompletion() {
        return (List<Complete>) completeRepository.findAll();
    }


    static Complete unwrapCompletion(Optional<Complete> entity, Long personId, Long taskId) {
        if (entity.isPresent()) return entity.get();
        else throw new GradeNotFoundException(personId, taskId);
    }
}
