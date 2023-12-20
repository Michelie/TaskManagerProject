package com.michelle.taskmanager.exception;

public class DashboardNotFoundException extends RuntimeException{

    public DashboardNotFoundException(Long id) {
        super("The dashboard id '" + id + "' does not exist in our records");
    }
}
