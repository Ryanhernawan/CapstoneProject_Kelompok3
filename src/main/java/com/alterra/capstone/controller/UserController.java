package com.alterra.capstone.controller;

import com.alterra.capstone.entity.User;
import com.alterra.capstone.payload.UserPayload;
import com.alterra.capstone.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserService userService;

    @GetMapping
    public ResponseEntity<BaseResponse<List<User>>> getAll(){
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse.setSuccess(true);
            baseResponse.setMessage("Get All Users");
            baseResponse.setData(userService.getAllUser());

        }catch (Exception e){
            baseResponse.setSuccess(false);
            baseResponse.setMessage("Failed to get user by ID");
            baseResponse.setData(null);
        }

        return new ResponseEntity(baseResponse, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        BaseResponse<User> baseResponse = new BaseResponse();
        if (userService.getUsersById(id) != null){
            baseResponse.setSuccess(true);
            baseResponse.setMessage("Get User by ID");
            baseResponse.setData(userService.getUsersById(id));
        }else {
            baseResponse.setSuccess(false);
            baseResponse.setMessage("Failed to get user by ID");
            baseResponse.setData(null);
            return new ResponseEntity(baseResponse, HttpStatus.BAD_REQUEST);
        }
        return new  ResponseEntity(baseResponse, HttpStatus.OK);
    }

    //Get By Role As SuperAdmin
    @GetMapping("/superadmin")
    private ResponseEntity<BaseResponse<User>> getUserAsSuperAdmin(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Get User as SuperAdmin");
        baseResponse.setData(userService.getUserByRoleSuperAdmin());
        return new ResponseEntity(baseResponse, HttpStatus.OK);
    }

    //Get By Role As Admin
    @GetMapping("/admin")
    private ResponseEntity<BaseResponse<User>> getUserAsAdmin(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Get User as Admin");
        baseResponse.setData(userService.getUserByRoleAdmin());
        return new ResponseEntity(baseResponse, HttpStatus.OK);
    }

    //Get By Role As users
    @GetMapping("/user")
    private ResponseEntity<BaseResponse<User>> getUserAsUser(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Get User");
        baseResponse.setData(userService.getUserByRoleUser());
        return new ResponseEntity(baseResponse, HttpStatus.OK);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @PostMapping("/register/superadmin")
    public ResponseEntity<BaseResponse<User>> registerSuperAdmin(@RequestBody UserPayload userPayload){
        BaseResponse baseResponse = new BaseResponse();
        if (!userPayload.getName().equals("") && userPayload.getName() != null &&
                !userPayload.getUsername().equals("") && userPayload.getUsername() != null &&
                !userPayload.getEmail().equals("") && userPayload.getEmail() != null &&
                !userPayload.getContact().equals("") && userPayload.getContact() != null &&
                !userPayload.getPassword().equals("") && userPayload.getPassword() != null
        ){
            baseResponse.setData(userService.registerAsSuperAdmin(userPayload));
            baseResponse.setSuccess(true);
            baseResponse.setMessage("Register Super Admin");
        }else {
            baseResponse.setData(null);
            baseResponse.setSuccess(false);
            baseResponse.setMessage("Failed to add Super Admin");
            return new ResponseEntity(baseResponse, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(baseResponse, HttpStatus.CREATED);
    }

    @PostMapping("/register/admin")
    public ResponseEntity<BaseResponse<User>> registerAdmin(@RequestBody UserPayload userPayload){
        BaseResponse baseResponse = new BaseResponse();
        if (!userPayload.getName().equals("") && userPayload.getName() != null &&
                !userPayload.getUsername().equals("") && userPayload.getUsername() != null &&
                !userPayload.getEmail().equals("") && userPayload.getEmail() != null &&
                !userPayload.getContact().equals("") && userPayload.getContact() != null &&
                !userPayload.getPassword().equals("") && userPayload.getPassword() != null
        ){
            baseResponse.setSuccess(true);
            baseResponse.setMessage("Register Admin");
            baseResponse.setData(userService.registerAsAdmin(userPayload));
        }else {
            baseResponse.setData(null);
            baseResponse.setSuccess(false);
            baseResponse.setMessage("Failed to add Admin");
            return new ResponseEntity(baseResponse, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(baseResponse, HttpStatus.CREATED);
    }

    @PostMapping("/register/user")
    public ResponseEntity<BaseResponse<User>> registerUser(@RequestBody UserPayload userPayload){
        BaseResponse baseResponse = new BaseResponse();
        if (!userPayload.getName().equals("") && userPayload.getName() != null &&
                !userPayload.getUsername().equals("") && userPayload.getUsername() != null &&
                !userPayload.getEmail().equals("") && userPayload.getEmail() != null &&
                !userPayload.getContact().equals("") && userPayload.getContact() != null &&
                !userPayload.getPassword().equals("") && userPayload.getPassword() != null
        ){
            baseResponse.setSuccess(true);
            baseResponse.setMessage("Register User");
            baseResponse.setData(userService.registerAsUser(userPayload));
        }else {
            baseResponse.setData(null);
            baseResponse.setSuccess(false);
            baseResponse.setMessage("Failed to add User");
            return new ResponseEntity(baseResponse, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(baseResponse, HttpStatus.CREATED);
    }

    @PutMapping("/update/password/{id}")
    public ResponseEntity<BaseResponse<User>> updatePassword(@PathVariable Long id, @RequestBody UserPayload payload){
        BaseResponse baseResponse = new BaseResponse();
        if ( userService.updatePassword(id, payload) != null && payload.getPassword() != null) {
            baseResponse.setSuccess(true);
            baseResponse.setMessage("Update Password");
            baseResponse.setData(userService.updatePassword(id, payload));
        }
        else {
            baseResponse.setData(null);
            baseResponse.setSuccess(false);
            baseResponse.setMessage("Failed to update Password");
            return new ResponseEntity(baseResponse, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(baseResponse, HttpStatus.OK);
    }

    // put mapping by ID hanya untuk Superadmin dan User
    // superadmin untuk edit data admin.
    // user edit data user itu sendiri
    @PutMapping("{id}")
    public ResponseEntity<BaseResponse<User>> editUser(@PathVariable Long id, @RequestBody UserPayload userPayload){
        BaseResponse baseResponse = new BaseResponse();
        if (!userPayload.getName().equals("") && userPayload.getName() != null &&
                !userPayload.getUsername().equals("") && userPayload.getUsername() != null &&
                userPayload.getEmail() != null &&
                !userPayload.getContact().equals("") && userPayload.getContact() != null &&
                !userPayload.getPassword().equals("") && userPayload.getPassword() != null
        ){
            baseResponse.setSuccess(true);
            baseResponse.setMessage("update User success");
            baseResponse.setData(userService.updateUser(id ,userPayload));
        }else {
            baseResponse.setData(null);
            baseResponse.setSuccess(false);
            baseResponse.setMessage("Failed to update");
            return new ResponseEntity(baseResponse, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(baseResponse, HttpStatus.OK);
    }
}
