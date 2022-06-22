package com.alterra.capstone.service;

import com.alterra.capstone.entity.Class;

import java.util.List;

public interface ClassService {
    List<Class> getAllClass();
    Class getClassById(Long id);
    Class createNewClass(Class payload);
    Class updateClass(Class payload);
    void deleteClasById(Long id);
    Class findClassByUser_Id(Long user);
    List<Class> getClassTypeOffline();
    List<Class> getClassTypeOnline();
    // List<Class> getCountClassJoined(Long user, Long id);







}
