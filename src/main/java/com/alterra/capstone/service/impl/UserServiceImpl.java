package com.alterra.capstone.service.impl;

import com.alterra.capstone.entity.User;
import com.alterra.capstone.payload.UserPayload;
import com.alterra.capstone.repository.UserRepository;
import com.alterra.capstone.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User register(UserPayload userPayload) {
        User user = new User();
        user.setUsername(userPayload.getUsername());
        user.setEmail(userPayload.getEmail());
        user.setContact(userPayload.getContact());
        user.setPassword(userPayload.getPassword());
        return userRepository.save(user);
    }

    //---------PR------------
    // update password sebelum login. pakai email untuk konfirmasi
    @Override
    public User updatePassword(@PathVariable Long id, UserPayload userPayload) {
        Optional<User> idUser = userRepository.findById(id);
        idUser.ifPresent(update -> {
            update.setPassword(userPayload.getPassword());
        });
        return userRepository.getById(id);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByid(@PathVariable Long id) {
        User user = new User();
        user = userRepository.findById(id).orElse(user);
        return user;
    }

    @Override
    public User deleteUser(Long id) {
        return null;
    }
}
