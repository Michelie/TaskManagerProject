package com.michelle.taskmanager.entity;

import com.michelle.taskmanager.validation.Level;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "complete")
public class Complete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Level
    @Column(name = "level", nullable = false)
    private String level;


    @ManyToOne(optional = false)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    @ManyToOne(optional = false)
    @JoinColumn(name = "task_id", referencedColumnName = "id")
    private Task task;

}

