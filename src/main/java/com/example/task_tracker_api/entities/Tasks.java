package com.example.task_tracker_api.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tasks")
@Entity
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // Task Properties
    private Long id;
    private String description;
    private String status; // to-do , in-progress, done, not-done.
    private String createdAt;
    private String updatedAt;
}
