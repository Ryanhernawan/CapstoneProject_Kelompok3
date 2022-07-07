package com.alterra.capstone.service;

import com.alterra.capstone.entity.User;
import com.alterra.capstone.payload.UserPayload;

import java.util.List;

public interface UserService {
    User registerAsSuperAdmin(UserPayload userPayload);
    User registerAsAdmin(UserPayload userPayload);
    User registerAsUser(UserPayload userPayload);
    User updatePassword(Long id, UserPayload userPayload);
    User updateUser(Long id, UserPayload userPayload);
    List<User> getAllUser();
    User getUsersById(Long id);
    List<User> getUserByRoleAdmin();
    List<User> getUserByRoleSuperAdmin();
    List<User> getUserByRoleUser();
    User emailUser(String email);
    Boolean idIsPresent(Long id);
    void deleteUser(Long id);
}
