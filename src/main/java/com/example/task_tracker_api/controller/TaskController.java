package com.example.task_tracker_api.controller;


import com.example.task_tracker_api.entities.Tasks;
import com.example.task_tracker_api.services.TaskServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskServices taskServices;

    public TaskController(TaskServices taskServices) {
        this.taskServices = taskServices;
    }

    // Creating new Task to Save Them

    @PostMapping
    public ResponseEntity<Tasks> saveTasks(@RequestBody Tasks tasks) {
        Tasks taskCreated = this.taskServices.saveTasks(tasks);
        return ResponseEntity.ok(taskCreated);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Tasks> updateTasks(@PathVariable Long id,@RequestBody Tasks tasksUpdated) {
        Tasks taskUpdated = this.taskServices.updateTasks(id,tasksUpdated);
        return ResponseEntity.ok(taskUpdated);
    }
    @DeleteMapping("/{id}")
    public void deleteTasks(@PathVariable Long id) {
        this.taskServices.deleteTasks(id);
    }
    @GetMapping
    public List<Tasks> listAllTasks(){
        return taskServices.listAllTasks();
    }
    public List<Tasks> listAllTasksByStatus(String status){
        return taskServices.listAllTasksByStatus(status);
    }
}
