package com.example.task_tracker_api.services;


import com.example.task_tracker_api.entities.Tasks;
import com.example.task_tracker_api.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Service
public class TaskServices {

    private final TaskRepository taskRepository;


    public TaskServices(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    @PostMapping
    public Tasks saveTasks(Tasks tasksRequest) {
        return this.taskRepository.save(tasksRequest);
    }
    @PutMapping
    public Tasks updateTasks(Long id, Tasks tasksRequest) {
        return taskRepository.findById(id)
                .map(tasks -> {
                    tasks.setDescription(tasksRequest.getDescription());
                    tasks.setStatus(tasksRequest.getStatus());
                    tasks.setCreatedAt(tasksRequest.getCreatedAt());
                    tasks.setUpdatedAt(tasksRequest.getUpdatedAt());
                    return taskRepository.save(tasks);
                })
                .orElseThrow(()-> new RuntimeException("Task Not Found: " + id));
    }
    @DeleteMapping
    public void deleteTasks(Long id) {
        this.taskRepository.deleteById(id);
    }
    public List<Tasks>listAllTasks(){
        return this.taskRepository.findAll();
    }
    public List<Tasks>listAllTasksByStatus(String status){
        return this.taskRepository.findByStatus(status);
    }
}
