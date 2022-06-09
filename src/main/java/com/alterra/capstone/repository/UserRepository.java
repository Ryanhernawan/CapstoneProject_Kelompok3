package com.alterra.capstone.repository;

import com.alterra.capstone.entity.Class;
import com.alterra.capstone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
//    User getUserClass();
//    @Query(value = "SELECT c FROM Class c where c.user.id=?1")
//    Class findClassByUser_Id(Long userId);
}
