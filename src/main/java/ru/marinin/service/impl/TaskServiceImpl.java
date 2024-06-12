package ru.marinin.service.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.stereotype.Service;
import ru.marinin.dto.TaskDto;
import ru.marinin.exception.ResourceNotFoundException;
import ru.marinin.mapper.TaskMapper;
import ru.marinin.models.Task;
import ru.marinin.repository.TaskRepository;
import ru.marinin.service.TaskService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public TaskDto createTask(TaskDto taskDto) {
        Task task = TaskMapper.mapToTask(taskDto);
        Task savedTask = taskRepository.save(task);
        return TaskMapper.mapToTaskDto(savedTask);
    }

    @Override
    public TaskDto getTaskById(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Task is not exists with given id: " + taskId));
        return TaskMapper.mapToTaskDto(task);
    }

    @Override
    public List<TaskDto> getAllTasks() {
        List<Task> taskList = taskRepository.findAll();
        return taskList.stream()
                .map(TaskMapper::mapToTaskDto)
                .toList();
    }

    @Override
    public TaskDto updateTask(Long taskId, TaskDto updatedTaskDto) {
        Task task = taskRepository.findById(taskId).orElseThrow(
                () -> new ResourceNotFoundException("Task is not exist with given id: " + taskId)
        );
        Task updatedTask = TaskMapper.mapToTask(updatedTaskDto);
        updatedTask.setId(task.getId());
        updatedTask = taskRepository.save(updatedTask);
        return TaskMapper.mapToTaskDto(updatedTask);
    }

    @Override
    public void removeTask(Long taskId) {
        taskRepository.findById(taskId).orElseThrow(
                () -> new ResourceNotFoundException("Task is not exist with given id: " + taskId)
        );
        taskRepository.deleteById(taskId);
    }
}
