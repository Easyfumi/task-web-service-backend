package ru.marinin.dto;

import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    private Long id;
    private String nameOfTask;
    private String description;
    private int day;
    private String time;
    private String email;

    public TaskDto(String nameOfTask, String description, int day, String time, String email) {
        this.nameOfTask = nameOfTask;
        this.description = description;
        this.day = day;
        this.time = time;
        this.email = email;
    }

}
