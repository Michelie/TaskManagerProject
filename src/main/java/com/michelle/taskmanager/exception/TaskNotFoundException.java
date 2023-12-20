package com.michelle.taskmanager.exception;

public class TaskNotFoundException extends RuntimeException{

    public TaskNotFoundException(Long id){
        super("The task id '" + id + "' does not exist");
    }
}
