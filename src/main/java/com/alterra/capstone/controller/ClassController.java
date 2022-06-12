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

    @GetMapping("/{id_class}")
    public ResponseEntity<?> getClassById(@PathVariable("id_class") Long id){
        BaseResponse<List<Class>> baseResponse = new BaseResponse<>();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Success Get Class By Id");
        baseResponse.setData(List.of(service.getClassById(id)));
        return ResponseEntity.ok(baseResponse);
    }

    // GET CLAS BY USER ID
    @GetMapping("/{user_id}")
    public ResponseEntity<?> findClassByUser_Id(@PathVariable("user_id") Long user){
        BaseResponse<List<Class>> baseResponse = new BaseResponse<>();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Success Get Class By User Id");
        baseResponse.setData(List.of(service.findClassByUser_Id(user)));
        return ResponseEntity.ok(baseResponse);
    }

    // GET CLASS TYPE OFFLINE
    @GetMapping("/offline")
    public ResponseEntity<?> getClassTypeOffline(){
        BaseResponse<List<Class>> baseResponse = new BaseResponse<>();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Success Get Class Type Offline");
        baseResponse.setData(service.getClassTypeOffline());
        return ResponseEntity.ok(baseResponse);
    }

    // GET CLASS TYPE ONLINE
    @GetMapping("/online")
    public ResponseEntity<?> getClassTypeOnline(){
        BaseResponse<List<Class>> baseResponse = new BaseResponse<>();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Success Get Class Type Online");
        baseResponse.setData(service.getClassTypeOnline());
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
