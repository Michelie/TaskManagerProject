package com.michelle.taskmanager.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title cannot be blank")
    @NonNull
    @Column(name = "title", nullable = false)
    private String title;

    @NotBlank(message = "Description cannot be blank")
    @NonNull
    @Column(name = "description", nullable = false)
    private String description;

    @NotNull(message = "Date cannot be null")
    @NonNull
    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

    @JsonIgnore
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<Complete> completes;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "task_person",
            joinColumns = @JoinColumn(name = "task_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id")
    )
    private Set<Person> persons;

}
