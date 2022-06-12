package com.alterra.capstone.controller;

import com.alterra.capstone.entity.Instructor;
import com.alterra.capstone.service.InstructorService;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;

@RestController
@RequestMapping ("/booking")
public class InstructorController {
    @Autowired
    InstructorService instructorService;

    @GetMapping
    public Iterable<Instructor> getAll() {
        return instructorService.getAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> InstructorById(@PathVariable("id") Integer id) {
        Instructor instructor = instructorService.getById(id);
        return ResponseEntity.ok(instructor);
    }

    @PostMapping
    public ResponseEntity<?> createInstructor(@RequestBody Instructor instructor) {
        Instructor instructorCreate = instructorService.create(instructor);
        return ResponseEntity.ok(instructorCreate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInstructor(@PathVariable("id") Integer id) {
        instructorService.delete(id);
        return ResponseEntity.notFound().build();
    }
}
