package com.alterra.capstone.service.impl;

import com.alterra.capstone.entity.Role;
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

    ////////////////////////__________Super Admin Service___________////////////////////////
    @Override
    public User registerAsSuperAdmin(UserPayload userPayload) {
        User user = new User();

        Role roleAdmin = new Role();
        roleAdmin.setId(1L);

        user.setName(userPayload.getName());
        user.setUsername(userPayload.getUsername());
        user.setEmail(userPayload.getEmail());
        user.setContact(userPayload.getContact());
        user.setPassword(userPayload.getPassword());
        user.setRole(roleAdmin);
        return userRepository.save(user);
    }

    @Override
    public List<User> getUserByRoleSuperAdmin() {
        return userRepository.getUserAsSuperAdmin();
    }

    ////////////////////////_____________Admin Service____________////////////////////////
    @Override
    public User registerAsAdmin(UserPayload userPayload) {
        User user = new User();

        Role roleAdmin = new Role();
        roleAdmin.setId(2L);

        user.setName(userPayload.getName());
        user.setUsername(userPayload.getUsername());
        user.setEmail(userPayload.getEmail());
        user.setContact(userPayload.getContact());
        user.setPassword(userPayload.getPassword());
        user.setRole(roleAdmin);
        return userRepository.save(user);
    }

    @Override
    public List<User> getUserByRoleAdmin() {
        return userRepository.getUserAsAdmin();
    }

    ////////////////////////______________User Service_____________////////////////////////
    @Override
    public User registerAsUser(UserPayload userPayload) {
        User user = new User();

        Role roleAdmin = new Role();
        roleAdmin.setId(3L);

        user.setName(userPayload.getName());
        user.setUsername(userPayload.getUsername());
        user.setAddress(userPayload.getAddress());
        user.setEmail(userPayload.getEmail());
        user.setContact(userPayload.getContact());
        user.setPassword(userPayload.getPassword());
        user.setRole(roleAdmin);
        return userRepository.save(user);
    }

    @Override
    public List<User> getUserByRoleUser() {
        return userRepository.getUserAsUser();
    }


    @Override
    public User getUsersById(@PathVariable Long id) {
        User user = new User();
        user = userRepository.findById(id).orElse(null);
        return user;
    }

    //---------PR------------
    // update password sebelum login. pakai email untuk konfirmasi
    @Override
    public User updatePassword(@PathVariable Long id, UserPayload userPayload) {
        Optional<User> idUser = userRepository.findById(id);
        idUser.ifPresent(update -> {
            update.setPassword(userPayload.getPassword());
            userRepository.save(update);
        });
        return userRepository.getReferenceById(id);
    }

    @Override
    public User updateUser(@PathVariable Long id, UserPayload userPayload) {
        Optional<User> userID =userRepository.findById(id);
        userID.ifPresent(updateUser ->{
            updateUser.setName(userPayload.getName());
            updateUser.setUsername(userPayload.getUsername());
            updateUser.setEmail(userPayload.getEmail());
            updateUser.setContact(userPayload.getContact());
            updateUser.setPassword(userPayload.getPassword());
            userRepository.save(updateUser);
        });
        return userRepository.getReferenceById(id);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(@PathVariable Long id) {
        Optional<User> userId = userRepository.findById(id);
        userId.ifPresent(action -> {
            userRepository.delete(action);
        });
    }
}
