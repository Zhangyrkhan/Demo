package com.example.demo.service;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public Task create(Task task) {
        return taskRepository.save(task);
    }

    public Optional<Task> getById(Long id) {
        return taskRepository.findById(id);
    }

    public List<Task> getAll(String status) {
        if (status == null || status.isBlank()) {
            return taskRepository.findAll();
        }
        return taskRepository.findByStatus(status);
    }

    public Task update(Long id, Task updatedTask) {
        return taskRepository.findById(id).map(task -> {
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setStatus(updatedTask.getStatus());
            return taskRepository.save(task);
        }).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}
