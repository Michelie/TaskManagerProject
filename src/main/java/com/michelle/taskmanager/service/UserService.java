package com.michelle.taskmanager.service;

import com.michelle.taskmanager.entity.User;

public interface UserService {
    User getUser(Long id);
    User getUser(String username);
    User saveUser(User user);
}