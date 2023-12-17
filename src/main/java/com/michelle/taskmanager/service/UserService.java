package com.michelle.taskmanager.service;

import com.michelle.taskmanager.entity.User;

public interface UserService {
    User createUser(User user);
    User getUserById(Long userId);
    User getUserByUsername(String username);
}
