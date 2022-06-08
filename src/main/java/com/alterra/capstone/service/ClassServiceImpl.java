package com.alterra.capstone.service;

import com.alterra.capstone.entity.GymClass;
import com.alterra.capstone.repository.ClassRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ClassServiceImpl implements ClassService{

    private final ClassRepository repository;


    @Override
    public List<GymClass> getAllClass() {
        return repository.findAll();
    }

    @Override
    public GymClass getClassById(Long id) {
        GymClass gymClass = new GymClass();
        gymClass = repository.findById(id).orElse(null);
        return gymClass;
    }

    @Override
    public GymClass createNewClass(GymClass payload) {
        return repository.save(payload);
    }

    @Override
    public GymClass updateClass(GymClass payload) {
        return repository.save(payload);
    }

    @Override
    public void deleteClasById(Long id) {
        repository.deleteById(id);
    }
}
