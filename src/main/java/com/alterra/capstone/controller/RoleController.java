package com.alterra.capstone.controller;

import com.alterra.capstone.entity.Role;
import com.alterra.capstone.payload.RolePayload;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.alterra.capstone.service.RoleService;

@RestController
@RequestMapping ("/role")
@RequiredArgsConstructor
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    public BaseResponse<Iterable<Role>> getAll() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("get All Role");
        baseResponse.setData(roleService.getAll());
        return baseResponse;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<Role>> RoleById(@PathVariable("id") Integer id) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Get Role By id");
        baseResponse.setData(roleService.getById(id));
        return ResponseEntity.ok(baseResponse);

    }

    @PostMapping
    public ResponseEntity<BaseResponse<Role>> createRole(@RequestBody RolePayload rolePayload) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Create role");
        baseResponse.setData(roleService.create(rolePayload));
        return ResponseEntity.ok(baseResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable("id") Integer id){
        roleService.delete(id);
        return ResponseEntity.notFound().build();
    }

    }
