package com.alterra.capstone.service.impl;

import com.alterra.capstone.entity.Class;
import com.alterra.capstone.payload.ClassPayload;
import com.alterra.capstone.repository.ClassRepository;
import com.alterra.capstone.service.ClassService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ClassServiceImpl implements ClassService {

    private final ClassRepository repository;


    @Override
    public List<Class> getAllClass() {
        return repository.getAllClass();
        //return repository.findAll();
    }

    @Override
    public Class getClassById(Long id) {
        Class gymClass = new Class();
        gymClass = repository.findById(id).orElse(null);
        return gymClass;
    }

    @Override
    public Class createOnlineClass(ClassPayload payload) {
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
    public Class createOfflineClass(ClassPayload payload) {
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
    public Class updateClass(Long id, ClassPayload payload) {
        Optional<Class> classId = repository.findById(id);
        classId.ifPresent(updateClass -> {
            updateClass.setName(payload.getName());
            updateClass.setIdInstructor(payload.getIdInstructor());
            updateClass.setStartAt(payload.getStartAt());
            //end_ad 2 jam dari start_at
            updateClass.setEndAt(payload.getEndAt());
            updateClass.setPrice(payload.getPrice());
            updateClass.setDescription(payload.getDescription());
            updateClass.setType(payload.getType());
            updateClass.setLocation(payload.getLocation());
            repository.save(updateClass);
        });
        return repository.getById(id);
    }

    @Override
    public void deleteClasById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Class> findClassByUser_Id(Long user) {
        return null;
    }

//    @Override
//    public List<Class> findClassByUser_Id(@PathVariable Long user) {
//        return repository.findClassByUser_Id(user);
//    }

    @Override
    public List<Class> getClassTypeOffline() {
        return repository.getClassTypeOffline();
    }

    @Override
    public List<Class> getClassTypeOnline() {
        return repository.getClassTypeOnline();
    }

    @Override
    public Set<Class> getClassByUserID() {
        return null;
    }

    // @Override
    // public List<Class> getCountClassJoined(Long user, Long id) {
    //     return repository.getCountClassJoined(user, id);
    // }

}
