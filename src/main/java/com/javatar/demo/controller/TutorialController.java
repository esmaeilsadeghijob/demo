package com.javatar.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.javatar.demo.model.Tutorial;
import com.javatar.demo.repository.TutorialRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/api")
public class TutorialController {

    @Autowired
    TutorialRepository tutorialRepository;

    @GetMapping("/tutorials")
    public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title) {
        return ResponseEntity.ok(tutorialRepository.findAll());
    }

    @GetMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id) {
        return ResponseEntity.ok(tutorialRepository.findById(id).get());
    }

    @PostMapping("/tutorials")
    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
        return ResponseEntity.ok(tutorialRepository.save(tutorial));
    }

//    @PutMapping("/tutorials/{id}")
//    public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
//    ...
//    }

    @DeleteMapping("/tutorials/{id}")
    public void deleteTutorial(@PathVariable("id") long id) {
        tutorialRepository.deleteById(id);
    }

    @DeleteMapping("/tutorials")
    public void deleteAllTutorials() {
        tutorialRepository.deleteAll();
    }

    @GetMapping("/tutorials/published")
    public ResponseEntity<List<Tutorial>> findByPublished() {
        return ResponseEntity.ok(tutorialRepository.findByPublished(Boolean.TRUE));
    }
}