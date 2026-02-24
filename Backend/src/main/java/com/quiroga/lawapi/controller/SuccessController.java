package com.quiroga.lawapi.controller;

import com.quiroga.lawapi.model.SuccessStory;
import com.quiroga.lawapi.service.ContentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/success")
public class SuccessController {

    private final ContentRepository contentRepository;

    public SuccessController(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @GetMapping
    public List<SuccessStory> listSuccessStories() {
        return contentRepository.findAllSuccessStories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuccessStory> getSuccessStoryById(@PathVariable Long id) {
        return contentRepository.findSuccessStoryById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}