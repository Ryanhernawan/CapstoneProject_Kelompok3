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
        baseResponse.setData(userService.getUserByid(id));
        return baseResponse;
    }

    @PostMapping
    public BaseResponse<User> registerUser(@RequestBody UserPayload userPayload){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Register new User");
        baseResponse.setData(userService.register(userPayload));
        return baseResponse;
    }
}
