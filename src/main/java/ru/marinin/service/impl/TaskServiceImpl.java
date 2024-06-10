package ru.marinin.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.marinin.dto.TaskDto;
import ru.marinin.mapper.TaskMapper;
import ru.marinin.models.Task;
import ru.marinin.repository.TaskRepository;
import ru.marinin.service.TaskService;

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
}
