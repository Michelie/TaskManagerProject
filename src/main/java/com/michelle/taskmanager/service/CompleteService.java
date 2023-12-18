package com.michelle.taskmanager.service;

import com.michelle.taskmanager.entity.Complete;

import java.util.List;

public interface CompleteService {
    Complete getCompletion(Long personId, Long taskId);
    Complete saveCompletion(Complete complete, Long personId, Long taskId);
    Complete updateCompletion(String level, Long personId, Long taskId);
    void deleteCompletion(Long personId, Long taskId);
    List<Complete> getPersonCompletion(Long personId);
    List<Complete> getTaskCompletion(Long taskId);
    List<Complete> getAllCompletion();
}
