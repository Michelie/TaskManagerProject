package com.michelle.taskmanager.repository;

import com.michelle.taskmanager.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
