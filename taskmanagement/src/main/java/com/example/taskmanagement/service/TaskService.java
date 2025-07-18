package com.example.taskmanagement.service;

import com.example.taskmanagement.model.Task;
import com.example.taskmanagement.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getTasksForProject(String projectId) {
        return taskRepository.findByProjectId(projectId);
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(String id, Task task) {
        Task existing = taskRepository.findById(id).orElseThrow();
        existing.setTitle(task.getTitle());
        existing.setDescription(task.getDescription());
        existing.setPriority(task.getPriority());
        existing.setAssignee(task.getAssignee());
        existing.setDueDate(task.getDueDate());
        existing.setStatus(task.getStatus());
        return taskRepository.save(existing);
    }
}