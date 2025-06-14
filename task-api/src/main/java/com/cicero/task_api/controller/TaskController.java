package com.cicero.task_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final List<String> tasks = new ArrayList<>(List.of("Treino", "Avante!"));

    @GetMapping
    public ResponseEntity<List<String>> getAll() {
        return ResponseEntity.ok(tasks);
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody String task) {
        if (task == null || task.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        tasks.add(task);
        return ResponseEntity.created(URI.create("/tasks/" + (tasks.size() - 1))).build();
    }
}
