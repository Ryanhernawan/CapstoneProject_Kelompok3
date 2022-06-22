package com.alterra.capstone.controller;

import com.alterra.capstone.entity.Instructor;
import com.alterra.capstone.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;

@RestController
@RequestMapping ("/instructor")
@RequiredArgsConstructor
public class InstructorController {
    @Autowired
    private InstructorService instructorService;

    @GetMapping
    public ResponseEntity<Iterable<Instructor>> getAll() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Get All Instructor");
        baseResponse.setData(instructorService.getAll());
        return new ResponseEntity(baseResponse, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> InstructorById(@PathVariable("id") Integer id) {
        BaseResponse baseResponse = new BaseResponse();
        if (instructorService.getById(id) != null) {
            baseResponse.setSuccess(true);
            baseResponse.setMessage("Get instructor by ID");
            baseResponse.setData(instructorService.getById(id));
        }else {
            baseResponse.setSuccess(false); 
            baseResponse.setMessage("Failed get instructor by ID");
            baseResponse.setData(instructorService.getById(id));
            return new ResponseEntity(baseResponse, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(baseResponse, HttpStatus.OK);
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
