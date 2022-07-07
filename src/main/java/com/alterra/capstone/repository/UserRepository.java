package com.alterra.capstone.repository;

import com.alterra.capstone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
//    User getUserClass();
//    @Query(value = "SELECT c FROM Class c where c.user.id=?1")
//    Class findClassByUser_Id(Long userId);
    @Query(value = "SELECT u FROM User u where u.role.id=1")
    List<User> getUserAsSuperAdmin();
    @Query(value = "SELECT u FROM User u where u.role.id=2")
    List<User> getUserAsAdmin();
    @Query(value = "SELECT u FROM User u where u.role.id=3")
    List<User> getUserAsUser();
    @Query(value = "SELECT * FROM users WHERE email = ':email'", nativeQuery = true)
    User getEmail(@Param("email") String email);

}
