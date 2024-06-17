package ru.marinin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.marinin.dto.TaskDto;
import ru.marinin.repository.TaskRepository;
import ru.marinin.service.impl.TaskServiceImpl;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskServiceImpl taskService;


    @PostMapping
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto) {
        var savedTask = taskService.createTask(taskDto);
        return new ResponseEntity<>(savedTask,
                HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable("id") Long taskId) {
        var taskDto = taskService.getTaskById(taskId);
        return ResponseEntity.ok(taskDto);
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        var list = taskService.getAllTasks();
        return ResponseEntity.ok(list);
    }

    @PutMapping("{id}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable("id") Long taskId,
                                              @RequestBody TaskDto updatedTaskDto) {
        TaskDto taskDto = taskService.updateTask(taskId, updatedTaskDto);
        return ResponseEntity.ok(taskDto);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> removeTask(@PathVariable("id") Long taskId) {
        taskService.removeTask(taskId);
        return ResponseEntity.ok("Employee deleted successfully");
    }
}
