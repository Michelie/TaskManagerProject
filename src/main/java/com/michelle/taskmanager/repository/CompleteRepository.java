package com.michelle.taskmanager.repository;

import com.michelle.taskmanager.entity.Complete;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompleteRepository extends JpaRepository<Complete, Long> {
    Optional<Complete> findByPersonIdAndTaskId(Long personId, Long taskId);
    List<Complete> findByPersonId(Long personId);
    List<Complete> findByTaskId(Long taskId);
    @Transactional
    void deleteByPersonIdAndTaskId(Long personId, Long taskId);
}
