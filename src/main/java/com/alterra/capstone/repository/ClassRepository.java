package com.alterra.capstone.repository;

import com.alterra.capstone.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ClassRepository extends JpaRepository<Class, Long> {

    //query find class by user id
    @Query(value = "SELECT c FROM  Class c WHERE c.user.id=?1")
    List<Class> findClassByUser_Id(Long user);

    //query find class by type = offline
    @Query(value = "SELECT c FROM  Class c WHERE c.type='offline'")
    List<Class> getClassTypeOffline();

    // query find class by type = online
    @Query(value = "SELECT c FROM  Class c WHERE c.type='online'")
    List<Class> getClassTypeOnline();

    // query count user on class
    // @Query(value = "SELECT c FROM Class c WHERE c.user.id=? AND c.id=?")
    // List<Class> getCountClassJoined(Long user, Long id);

}
