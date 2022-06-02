package com.capstone.kelompok3.controller;

import com.capstone.kelompok3.service.Instructors.InstructorsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
@AllArgsConstructor
public class InstructorsController {
    private final InstructorsService service;
}
