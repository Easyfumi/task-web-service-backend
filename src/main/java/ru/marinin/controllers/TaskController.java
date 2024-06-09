package ru.marinin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.marinin.models.Task;
import ru.marinin.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
private final TaskRepository taskRepository;
    @GetMapping
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @PostMapping
    private void createTestTask() {
        Task task = new Task();
        task.setDateTime(LocalDateTime.now());
        task.setDescription("asdasd");
        taskRepository.save(task);
    }
}
