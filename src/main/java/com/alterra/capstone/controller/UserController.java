package com.alterra.capstone.controller;

import com.alterra.capstone.entity.User;
import com.alterra.capstone.payload.UserPayload;
import com.alterra.capstone.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserService userService;

    @GetMapping
    public BaseResponse<List<User>> getAll(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Get All Users");
        baseResponse.setData(userService.getAllUser());
        return baseResponse;
    }

    @GetMapping("{id}")
    public BaseResponse<User> getById(@PathVariable Long id){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Get User By id");
        baseResponse.setData(userService.getUsersById(id));
        return baseResponse;
    }

    //Get By Role As SuperAdmin
    @GetMapping("/superadmin")
    private BaseResponse<User> getUserAsADmin(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Get User as SuperAdmin");
        baseResponse.setData(userService.getUserByRoleSuperAdmin());
        return baseResponse;
    }

    //Get By Role As Admin
    @GetMapping("/admin")
    private BaseResponse<User> getUserAsAdmin(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Get User as Admin");
        baseResponse.setData(userService.getUserByRoleAdmin());
        return baseResponse;
    }

    //Get By Role As users
    @GetMapping("/user")
    private BaseResponse<User> getUserAsUser(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Get User");
        baseResponse.setData(userService.getUserByRoleUser());
        return baseResponse;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @PostMapping("/register/superadmin")
    public BaseResponse<User> registerSuperAdmin(@RequestBody UserPayload userPayload){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Register Super Admin");
        baseResponse.setData(userService.registerAsSuperAdmin(userPayload));
        return baseResponse;
    }

    @PostMapping("/register/admin")
    public BaseResponse<User> registerAdmin(@RequestBody UserPayload userPayload){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Register Admin");
        baseResponse.setData(userService.registerAsAdmin(userPayload));
        return baseResponse;
    }

    @PostMapping("/register/user")
    public BaseResponse<User> registerUser(@RequestBody UserPayload userPayload){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Register new User");
        baseResponse.setData(userService.registerAsUser(userPayload));
        return baseResponse;
    }

    // put mapping by ID hanya untuk Superadmin dan User
    // superadmin untuk edit data admin.
    // user edit data user itu sendiri
    @PutMapping("{id}")
    public BaseResponse<User> editUser(@PathVariable Long id, @RequestBody UserPayload userPayload){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Edit User " + id);
        baseResponse.setData(userService.updateUser(id, userPayload));
        return baseResponse;
    }
}
