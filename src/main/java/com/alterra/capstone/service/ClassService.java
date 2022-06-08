package com.alterra.capstone.service;

import com.alterra.capstone.entity.GymClass;

import java.util.List;

public interface ClassService {
    List<GymClass> getAllClass();
    GymClass getClassById(Long id);
    GymClass createNewClass(GymClass payload);
    GymClass updateClass(GymClass payload);
    void deleteClasById(Long id);






}
