package com.alterra.capstone.service;

import com.alterra.capstone.entity.User;
import com.alterra.capstone.payload.UserPayload;

import java.util.List;

public interface UserService {
    User register(UserPayload userPayload);
    User updatePassword(Long id, UserPayload userPayload);
    List<User> getAllUser();
    User getUserByid(Long id);
    User deleteUser(Long id);
}
