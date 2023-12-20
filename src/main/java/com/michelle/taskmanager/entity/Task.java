package com.michelle.taskmanager.entity;



import com.michelle.taskmanager.validation.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

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


//    @Enumerated(EnumType.STRING)
//    @EnumValid(enumClass = TaskStatus.class)
//    @Column(name = "status", nullable = false)
//    private TaskStatus status;

    @Status
    @NonNull
    @Column(name = "status", nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "dashboard_id")
    private Dashboard dashboard;

}
