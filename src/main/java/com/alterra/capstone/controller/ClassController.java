package com.alterra.capstone.controller;

import com.alterra.capstone.entity.BaseResponse;
import com.alterra.capstone.entity.Class;
import com.alterra.capstone.service.ClassService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class")
@AllArgsConstructor
public class ClassController {

    private final ClassService service;

    @GetMapping
    public ResponseEntity<?> getAllClass(){
        BaseResponse<List<Class>> baseResponse = new BaseResponse<>();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Success Get All Class");
        baseResponse.setData(service.getAllClass());
        return ResponseEntity.ok(baseResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClassById(@PathVariable("id") Long id){
        BaseResponse<List<Class>> baseResponse = new BaseResponse<>();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Success Get Class By Id");
        baseResponse.setData(List.of(service.getClassById(id)));
        return ResponseEntity.ok(baseResponse);
    }

    @PostMapping
    public ResponseEntity<?> createNewClass(@RequestBody Class payload){
        BaseResponse<Class> baseResponse = new BaseResponse<>();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Success Create New Class");
        baseResponse.setData(service.createNewClass(payload));
        return ResponseEntity.ok(baseResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateClass(@PathVariable("id") Long id, Class payload){
        BaseResponse<Class> baseResponse = new BaseResponse<>();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Success Update Class");
        payload.setId(id);
        baseResponse.setData(service.updateClass(payload));
        return ResponseEntity.ok(baseResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClassById(@PathVariable("id") Long id){
        service.deleteClasById(id);
        return ResponseEntity.ok("Success Delete Class");
    }
}
