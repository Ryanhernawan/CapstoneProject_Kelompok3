package com.alterra.capstone.controller;

import com.alterra.capstone.entity.Role;
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
    public Iterable<Role> getAll() {
        return roleService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> RoleById(@PathVariable("id") Integer id) {
        Role role = roleService.getById(id);
        return ResponseEntity.ok(role);

    }

    @PostMapping
    public ResponseEntity<?> createRole(@RequestBody Role role) {
        Role roleCreate = roleService.create(role);
        return ResponseEntity.ok(roleCreate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable("id") Integer id){
        roleService.delete(id);
        return ResponseEntity.notFound().build();
    }

    }
