package ru.marinin.mapper;

import ru.marinin.dto.TaskDto;
import ru.marinin.models.Task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TaskMapper {
    public static TaskDto mapToTaskDto(Task task) {
        var dateTime = task.getDateTime();
        int day = dateTime.getDayOfMonth();
        int hour = dateTime.getHour();
        int min = dateTime.getMinute();
        String time = hour + ":" + min;

        return new TaskDto(task.getId(),
                task.getNameOfTask(),
                task.getDescription(),
                day,
                time,
                task.getEmail());
    }

    public static Task mapToTask(TaskDto taskDto) {
        var timeNow = LocalDateTime.now();
        LocalDate localDate = LocalDate.of(timeNow.getYear(), timeNow.getMonth(), taskDto.getDay());
        String[] timeParse = taskDto.getTime().split(":");
        LocalTime localTime = LocalTime.of(Integer.parseInt(timeParse[0]), Integer.parseInt(timeParse[1]));
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        return new Task(taskDto.getId(),
                taskDto.getNameOfTask(),
                taskDto.getDescription(),
                localDateTime,
                taskDto.getEmail());
    }
}
