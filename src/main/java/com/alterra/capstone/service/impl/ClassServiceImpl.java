package com.alterra.capstone.service.impl;

import com.alterra.capstone.entity.Class;
import com.alterra.capstone.entity.Instructor;
import com.alterra.capstone.repository.ClassRepository;
import com.alterra.capstone.service.ClassService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
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
    public Class createOnlineClass(Class payload) {
        Class addClass = new Class();
        addClass.setName(payload.getName());
        addClass.setIdInstructor(payload.getIdInstructor());
        addClass.setStartAt(payload.getStartAt());
        //end_ad 2 jam dari start_at
        addClass.setEndAt(payload.getStartAt().plus(Duration.ofMinutes(120)));
        addClass.setPrice(payload.getPrice());
        addClass.setDescription(payload.getDescription());
        addClass.setType("Online");
        addClass.setLocation("From Home");
        addClass.setQtyUsers(25);
        return repository.save(addClass);
    }

    @Override
    public Class createOfflineClass(Class payload) {
        Class addClass = new Class();
        addClass.setName(payload.getName());
        addClass.setIdInstructor(payload.getIdInstructor());
        addClass.setStartAt(payload.getStartAt());
        //end_ad 2 jam dari start_at
        addClass.setEndAt(payload.getStartAt().plus(Duration.ofMinutes(120)));
        addClass.setPrice(payload.getPrice());
        addClass.setDescription(payload.getDescription());
        addClass.setType("Offline");
        addClass.setLocation(payload.getLocation());
        addClass.setQtyUsers(25);
        return repository.save(addClass);
    }

    @Override
    public Class updateClass(Class payload) {
        return repository.save(payload);
    }

    @Override
    public void deleteClasById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Class findClassByUser_Id(Long user) {
        return repository.findClassByUser_Id(user);
    }

    @Override
    public List<Class> getClassTypeOffline() {
        return repository.getClassTypeOffline();
    }

    @Override
    public List<Class> getClassTypeOnline() {
        return repository.getClassTypeOnline();
    }

}
