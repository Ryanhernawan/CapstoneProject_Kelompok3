package com.alterra.capstone.service.impl;

import com.alterra.capstone.entity.Class;
import com.alterra.capstone.repository.ClassRepository;
import com.alterra.capstone.service.ClassService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ClassServiceImpl implements ClassService {

    private final ClassRepository repository;


    @Override
    public List<Class> getAllClass() {
        return repository.findAll();
    }

    @Override
    public Class getClassById(Long id) {
        Class gymClass = new Class();
        gymClass = repository.findById(id).orElse(null);
        return gymClass;
    }

    @Override
    public Class createNewClass(Class payload) {
        return repository.save(payload);
    }

    @Override
    public Class updateClass(Class payload) {
        return repository.save(payload);
    }

    @Override
    public void deleteClasById(Long id) {
        repository.deleteById(id);
    }

//    @Override
//    public Class findClassByUser_Id(Long user) {
//        return repository.findClassByUser_Id(user);
//    }
}
