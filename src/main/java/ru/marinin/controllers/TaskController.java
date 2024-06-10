package ru.marinin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.marinin.dto.TaskDto;
import ru.marinin.models.Task;
import ru.marinin.repository.TaskRepository;
import ru.marinin.service.TaskService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskRepository taskRepository;

    private final TaskService taskService;

    @GetMapping
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

//    @PostMapping
//    private void createTestTask() {
//        Task task = new Task();
//        task.setDateTime(LocalDateTime.now());
//        task.setNameOfTask("namenamename");
//        task.setDescription("descriptiondescriptiondescription");
//        task.setEmail("emailemailemail");
//        taskRepository.save(task);
//    }

    @PostMapping
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto) {
        TaskDto savedTask = taskService.createTask(taskDto);
        return new ResponseEntity<>(savedTask,
                HttpStatus.CREATED);
    }
}
