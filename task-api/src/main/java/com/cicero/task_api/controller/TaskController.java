package com.cicero.task_api.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/tasks", consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class TaskController {

    private final List<String> tasks = new ArrayList<>(List.of(
        "Treino",
        "Avante"
    ));


    @GetMapping(consumes = MediaType.ALL_VALUE) 
    public ResponseEntity<List<String>> getAll() {
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(tasks);
    }


    @PostMapping
    public ResponseEntity<Void> add(@RequestBody String task) {

        if (task == null || task.trim().isEmpty()) {
            return ResponseEntity
                    .badRequest()
                    .build();
        }

        tasks.add(task.trim());
        URI location = URI.create("/tasks/" + (tasks.size() - 1));
        return ResponseEntity
                .created(location)
                .build();
    }
}
