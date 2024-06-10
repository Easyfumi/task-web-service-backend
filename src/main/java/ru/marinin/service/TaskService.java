package ru.marinin.service;

import ru.marinin.dto.TaskDto;

public interface TaskService {
    TaskDto createTask(TaskDto taskDto);
}
