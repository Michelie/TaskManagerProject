package com.michelle.taskmanager.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message =  "username cannot be blank")
    @NonNull
    @Column(nullable = false, unique = true)
    private String username;

    @NotBlank(message =  "password cannot be blank")
    @NonNull
    @Column(nullable = false)
    private String password;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Dashboard> dashboards;
}
