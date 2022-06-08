package com.alterra.capstone.controller;

import com.alterra.capstone.entity.BaseResponse;
import com.alterra.capstone.entity.GymClass;
import com.alterra.capstone.service.ClassService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/class")
@AllArgsConstructor
public class GymClassController {

    private final ClassService service;

//    @GetMapping
//    public ResponseEntity<?> getAllClass(){
//        BaseResponse<List<GymClass>> baseResponse = new BaseResponse<>();
//        baseResponse.setSuccess(true);
//        baseResponse.setData(service.getAllClass());
//        return ResponseEntity.ok(baseResponse);
//    }
}
