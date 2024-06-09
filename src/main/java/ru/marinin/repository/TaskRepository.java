package ru.marinin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.marinin.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
