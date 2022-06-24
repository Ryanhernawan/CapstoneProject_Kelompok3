package com.alterra.capstone.service;

import com.alterra.capstone.entity.Class;
import com.alterra.capstone.payload.ClassPayload;

import java.util.List;
import java.util.Set;

public interface ClassService {
    List<Class> getAllClass();
    Class getClassById(Long id);
    Class createOnlineClass(ClassPayload payload);
    Class createOfflineClass(ClassPayload payload);
    Class updateClass(Long id, ClassPayload payload);
    void deleteClasById(Long id);
    List<Class> findClassByUser_Id(Long user);
    List<Class> getClassTypeOffline();
    List<Class> getClassTypeOnline();
    Set<Class> getClassByUserID();
    // List<Class> getCountClassJoined(Long user, Long id);







}
